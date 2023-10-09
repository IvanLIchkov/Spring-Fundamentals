package com.exam.shoppinglist.services;

import com.exam.shoppinglist.models.dtos.LogInDto;
import com.exam.shoppinglist.models.dtos.RegisterUserDto;

public interface UserService {

    void registerUser(RegisterUserDto registerUserDto);

     boolean login(LogInDto logInDto);

    boolean isLogged();

    void logOut();
}
