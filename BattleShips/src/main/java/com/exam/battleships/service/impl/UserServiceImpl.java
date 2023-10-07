package com.exam.battleships.service.impl;

import com.exam.battleships.models.dtos.LoginDto;
import com.exam.battleships.models.entities.User;
import com.exam.battleships.models.dtos.UserRegisterDto;
import com.exam.battleships.repositories.UserRepository;
import com.exam.battleships.service.UserService;
import com.exam.battleships.session.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        User user = this.mapper.map(userRegisterDto, User.class).setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        this.userRepository.save(user);
    }

    @Override
    public boolean login(LoginDto loginDto) {
        User user = this.userRepository.findByUsername(loginDto.getUsername()).orElse(null);
boolean loginSuccess = false;

        if(user!=null){
            String rawPassword = loginDto.getPassword();
            String encodedPassword = user.getPassword();

            loginSuccess = passwordEncoder.matches(rawPassword, encodedPassword);
        }
        if (loginSuccess){
           this.currentUser.login(user);
        }
        return loginSuccess;
    }

    @Override
    public void logOut(){
        this.currentUser.logout();
    }
}
