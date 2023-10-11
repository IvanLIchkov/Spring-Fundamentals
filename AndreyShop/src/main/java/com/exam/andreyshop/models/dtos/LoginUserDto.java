package com.exam.andreyshop.models.dtos;

import com.exam.andreyshop.models.validations.UsernameMatch;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginUserDto {

    @NotEmpty(message = "Required field!")
    @Size(min = 2, message = "Length must be more than 2 characters!")
    private String username;

    @NotEmpty(message = "Required field!")
    @Size(min = 2, message = "Length must be more than 2 characters!")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
