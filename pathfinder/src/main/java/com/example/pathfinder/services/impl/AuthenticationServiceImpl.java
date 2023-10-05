package com.example.pathfinder.services.impl;

import com.example.pathfinder.models.dtos.UserRegistrationDto;
import com.example.pathfinder.models.entities.User;
import com.example.pathfinder.repositories.UserRepository;
import com.example.pathfinder.services.AuthenticationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private ModelMapper mapper;

    @Autowired
    public AuthenticationServiceImpl (UserRepository userRepository, ModelMapper mapper){
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public void register(UserRegistrationDto userRegistrationDto) {
        if(!userRegistrationDto.getPassword().equals(userRegistrationDto.getConfirmPassword())){
            throw new RuntimeException("passwords.match");
        }
        Optional<User> byEmail = this.userRepository.findByEmail(userRegistrationDto.getEmail());

        if (byEmail.isPresent()){
            throw new RuntimeException("email.used");
        }
        this.userRepository.save(this.mapper.map(userRegistrationDto, User.class));
//        User user = new User(userRegistrationDto.getUsername(),
//                userRegistrationDto.getPassword(),
//                userRegistrationDto.getEmail(),
//                userRegistrationDto.getFullName(),
//                userRegistrationDto.getAge());
//
//        this.userRepository.save(user);
//        User userToPersist = this.mapper.map(userRegistrationDto, User.class);

    }
}
