package com.exam.andreyshop.services.impl;

import com.exam.andreyshop.models.dtos.LoginUserDto;
import com.exam.andreyshop.models.dtos.RegisterUserDto;
import com.exam.andreyshop.models.entities.User;
import com.exam.andreyshop.repositories.UserRepository;
import com.exam.andreyshop.services.UserService;
import com.exam.andreyshop.session.CurrentUser;
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
    public void registerUser(RegisterUserDto registerUserDto) {
        User userToPersist = this.mapper.map(registerUserDto, User.class);
        userToPersist.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
        this.userRepository.save(userToPersist);
    }

    @Override
    public boolean loginUser(LoginUserDto loginUserDto) {
        User user = this.userRepository.findByUsername(loginUserDto.getUsername()).orElse(null);

        boolean isLogged = false;

        if (user != null) {
            String rawPass = loginUserDto.getPassword();
            String encodedPass = user.getPassword();
            isLogged = passwordEncoder.matches(rawPass, encodedPass);
        }
        if(isLogged){
            this.currentUser.login(user.getId());
        }

        return isLogged;
    }

    @Override
    public void logOut() {
        this.currentUser.logout();
    }

    @Override
    public boolean isLogged() {
        return this.currentUser.getId() != null;
    }
}
