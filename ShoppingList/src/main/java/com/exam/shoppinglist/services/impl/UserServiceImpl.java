package com.exam.shoppinglist.services.impl;

import com.exam.shoppinglist.models.dtos.LogInDto;
import com.exam.shoppinglist.models.dtos.RegisterMapper;
import com.exam.shoppinglist.models.dtos.RegisterUserDto;
import com.exam.shoppinglist.models.entities.User;
import com.exam.shoppinglist.repositories.UserRepository;
import com.exam.shoppinglist.services.UserService;
import com.exam.shoppinglist.session.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RegisterMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, RegisterMapper mapper1, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.mapper = mapper1;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(RegisterUserDto registerUserDto) {
        User user = this.mapper.registerDtoToUserEntity(registerUserDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       this.userRepository.save(user);
    }

    @Override
    public boolean login(LogInDto logInDto) {
        Optional<User> user = this.userRepository.findByUsername(logInDto.getUsername());
        boolean loginSuccess = false;

        if(user.isEmpty()){
            return false;
        }
        String rawPass = logInDto.getPassword();
        String encoded = user.get().getPassword();
        if(!passwordEncoder.matches(rawPass,encoded)){
            return false;
        }
        User userGet = user.get();
        currentUser.setId(userGet.getId());
        currentUser.setName(userGet.getUsername());
        return true;
    }

    @Override
    public boolean isLogged(){
        return this.currentUser.getId() != null;
    }

    @Override
    public void logOut() {
        this.currentUser.logout();
    }
}
