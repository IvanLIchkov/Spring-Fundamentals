package com.exam.coffeeshop.services;

import com.exam.coffeeshop.models.dtos.LoginDto;
import com.exam.coffeeshop.models.dtos.UserRegistrationDto;
import com.exam.coffeeshop.models.dtos.UserShowDto;
import com.exam.coffeeshop.models.entities.User;

import java.util.List;

public interface UserService {

    void registerUser(UserRegistrationDto userRegistrationDto);

    boolean loginUser(LoginDto loginDto);

    void logout();

    User getUserById();

    List<UserShowDto> showEmployeeOrderByNumOfOrders();
}
