package com.example.pathfinder.services.impl;

import com.example.pathfinder.models.dtos.UserRegistrationDto;
import com.example.pathfinder.models.entities.User;
import com.example.pathfinder.models.enums.LevelEnum;
import com.example.pathfinder.models.enums.RoleTypes;
import com.example.pathfinder.repositories.UserRepository;
import com.example.pathfinder.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public void registerUser(UserRegistrationDto userRegistrationDto) {
    }
}
