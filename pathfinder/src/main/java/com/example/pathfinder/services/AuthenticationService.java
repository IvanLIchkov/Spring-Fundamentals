package com.example.pathfinder.services;

import com.example.pathfinder.models.dtos.UserRegistrationDto;

public interface AuthenticationService {

    void register(UserRegistrationDto userRegistrationDto);
}
