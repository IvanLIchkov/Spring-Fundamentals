package com.exam.battleships.models.dtos;

import com.exam.battleships.models.validation.EmailValidation;
import com.exam.battleships.models.validation.PasswordMatch;
import com.exam.battleships.models.validation.UsernameMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@PasswordMatch(first = "password", second = "confirmPassword", message = "Passwords do not match!")
public class UserRegisterDto {

    @NotEmpty(message = "Username must not be empty!")
    @Size(min = 3, max = 20, message = "Length must be between 3 and 20 symbols!")
    @UsernameMatch
    private String username;

    @NotEmpty(message = "Full name must not be empty!")
    @Size(min = 5, max = 20, message = "Length must be between 5 and 20 symbols!")
    private String fullName;

    @Email
    @EmailValidation
    private String email;

    @NotEmpty(message = "Password must not be empty!")
    @Size(min = 3, message = "Password size must be at lest 3 symbols!")
    private String password;

    @NotEmpty(message = "Password must not be empty!")
    @Size(min = 3, message = "Password size must be at lest 3 symbols!")
    private String confirmPassword;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
