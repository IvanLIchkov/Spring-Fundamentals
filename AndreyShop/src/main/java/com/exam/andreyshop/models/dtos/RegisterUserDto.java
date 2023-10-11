package com.exam.andreyshop.models.dtos;

import com.exam.andreyshop.models.validations.PasswordMatch;
import com.exam.andreyshop.models.validations.UsernameMatch;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@PasswordMatch(first = "password", second = "confirmPassword", message = "Passwords doesn't match!")
public class RegisterUserDto {

    @NotEmpty(message = "Required field!")
    @UsernameMatch(message = "Username already exist!")
    @Size(min = 2, message = "Length must be more than 2 characters!")
    private String username;

    @Email(message = "Invalid email!")
    @NotEmpty(message = "Required field!")
    private String email;

    @NotNull(message = "Required field!")
    @Positive(message = "Budget must be positive number!")
    private BigDecimal budget;

    @NotEmpty(message = "Required field!")
    @Size(min = 2, message = "Length must be more than 2 characters!")
    private String password;

    @NotEmpty(message = "Required field!")
    @Size(min = 2, message = "Length must be more than 2 characters!")
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
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
