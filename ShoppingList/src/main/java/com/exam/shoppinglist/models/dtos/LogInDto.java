package com.exam.shoppinglist.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LogInDto {

    @NotEmpty(message = "Username must not be empty!")
    @Size(min = 3, max = 20, message = "Length must be between 3 and 20 symbols")
    private String username;

    @NotEmpty(message = "Password must not be empty!")
    @Size(min = 3, max = 20, message = "Length must be between 3 and 20 symbols")
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
