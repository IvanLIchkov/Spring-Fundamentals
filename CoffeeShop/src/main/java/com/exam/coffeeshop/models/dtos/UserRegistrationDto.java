package com.exam.coffeeshop.models.dtos;

import com.exam.coffeeshop.models.validations.EmailValidation;
import com.exam.coffeeshop.models.validations.PasswordMatch;
import com.exam.coffeeshop.models.validations.UsernameMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@PasswordMatch(first = "password", second = "confirmPassword")
public class UserRegistrationDto {

    @UsernameMatch
    @NotEmpty
    @Size(min = 5, max = 20)
    private String username;

    private String firstName;

    @NotEmpty
    @Size(min = 5, max = 20)
    private String lastName;

    @EmailValidation
    @Email
    private String email;

    @NotEmpty
    @Size(min = 3)
    private String password;

    @NotEmpty
    @Size(min = 3)
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
