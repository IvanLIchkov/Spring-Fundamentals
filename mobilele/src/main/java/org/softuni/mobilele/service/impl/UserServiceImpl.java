package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.dto.UserMapper;
import org.softuni.mobilele.model.dto.UserLoginDTO;
import org.softuni.mobilele.model.dto.UserRegistrationDTO;
import org.softuni.mobilele.model.entity.UserEntity;
import org.softuni.mobilele.repository.UserRepository;
import org.softuni.mobilele.service.UserService;
import org.softuni.mobilele.util.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           CurrentUser currentUser,
                           UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
        this.userMapper = userMapper;
    }

    @ModelAttribute("userLogin")
    public UserLoginDTO userLoginDTO(){
        return new UserLoginDTO();
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        userRepository.save(map(userRegistrationDTO));
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {
        var userEntity = userRepository
                .getFirstByEmail(userLoginDTO.getEmail())
                .orElse(null);

        boolean loginSuccess = false;

        if (userEntity != null){
            String rawPassword = userLoginDTO.getPassword();
            String encodedPassword = userEntity.getPassword();

            loginSuccess = passwordEncoder.matches(rawPassword, encodedPassword);

            if(loginSuccess) {
                currentUser.setFirstName(userEntity.getFirstName())
                        .setLastName(userEntity.getLastName())
                        .setLogged(true);
            }else{
                currentUser.logout();
            }
        }



        return loginSuccess;

    }

    @Override
    public void logoutUser() {
        currentUser.logout();
    }

    private UserEntity map(UserRegistrationDTO userRegistrationDTO){
        return userMapper.userDtoToUserEntity(userRegistrationDTO);
    }
}
