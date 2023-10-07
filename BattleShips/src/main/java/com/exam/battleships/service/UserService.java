package com.exam.battleships.service;

import com.exam.battleships.models.dtos.LoginDto;
import com.exam.battleships.models.dtos.UserRegisterDto;

public interface UserService {

    void registerUser(UserRegisterDto userRegisterDto);

    boolean login(LoginDto loginDto);

    void logOut();
}
