package org.softuni.mobilele.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import org.softuni.mobilele.model.validation.FieldMatch;
import org.softuni.mobilele.model.validation.UniqueUserEmail;

@FieldMatch(first = "password", second = "confirmPassword", message = "Passwords do not match.")
public class UserRegistrationDTO {
    @NotEmpty @Size(min = 2, max = 20)
    private String firstName;

    @NotEmpty @Size(min = 2, max = 20)
    private String lastName;

    @NotEmpty(message = "User email should be provided") @Email(message = "User email should be valid.")
    @UniqueUserEmail(message = "User email should be unique")
    private String email;

    @NotEmpty @Size(min = 5, max = 20)
    private String password;

    @NotEmpty @Size(min = 5, max = 20)
    private String confirmPassword;

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
