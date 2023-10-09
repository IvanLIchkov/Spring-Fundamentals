package com.exam.shoppinglist.models.dtos;

import com.exam.shoppinglist.models.validations.PasswordMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@PasswordMatch(first = "password", second = "confirmPassword", message = "Passwords doesn't match!")
public class RegisterUserDto {

    @NotEmpty
    @Size(min = 3, max = 20)
    private String username;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 3, max = 20)
    private String password;

    @Size(min = 3, max = 20)
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
