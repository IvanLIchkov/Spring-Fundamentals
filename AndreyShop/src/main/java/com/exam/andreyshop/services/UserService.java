package com.exam.andreyshop.services;

import com.exam.andreyshop.models.dtos.LoginUserDto;
import com.exam.andreyshop.models.dtos.RegisterUserDto;

public interface UserService {

    void registerUser(RegisterUserDto registerUserDto);

    boolean loginUser(LoginUserDto loginUserDto);

    void logOut();

    boolean isLogged();
}
