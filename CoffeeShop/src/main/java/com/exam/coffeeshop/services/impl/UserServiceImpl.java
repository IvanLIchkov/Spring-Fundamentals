package com.exam.coffeeshop.services.impl;

import com.exam.coffeeshop.models.dtos.LoginDto;
import com.exam.coffeeshop.models.dtos.RegisterUserMapper;
import com.exam.coffeeshop.models.dtos.UserRegistrationDto;
import com.exam.coffeeshop.models.dtos.UserShowDto;
import com.exam.coffeeshop.models.entities.User;
import com.exam.coffeeshop.repositories.UserRepository;
import com.exam.coffeeshop.services.UserService;
import com.exam.coffeeshop.session.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RegisterUserMapper mapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RegisterUserMapper mapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserRegistrationDto userRegistrationDto) {
        User user = mapper.userRegistrationDtoToUserEntity(userRegistrationDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
    }

    @Override
    public boolean loginUser(LoginDto loginDto) {
        User user = this.userRepository.findByUsername(loginDto.getUsername()).orElse(null);

        boolean loginSuccess = false;

        if(user!=null){
            String rawPass = loginDto.getPassword();
            String encodedPass = user.getPassword();

            loginSuccess = passwordEncoder.matches(rawPass, encodedPass);
        }
        if(loginSuccess){
            this.currentUser.login(user.getId());
        }

        return loginSuccess;
    }

    @Override
    public void logout() {
        this.currentUser.logOut();
    }

    @Override
    public User getUserById(){
        return this.userRepository.findById(currentUser.getId()).get();
    }

    @Override
    public List<UserShowDto> showEmployeeOrderByNumOfOrders() {
        return this.userRepository.findAllOrderByNumOfOrders();
    }


}
