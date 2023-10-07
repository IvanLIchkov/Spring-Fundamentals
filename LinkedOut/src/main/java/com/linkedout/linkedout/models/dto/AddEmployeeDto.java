package com.linkedout.linkedout.models.dto;

import com.linkedout.linkedout.models.enums.EducationLevelEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AddEmployeeDto {


    @NotEmpty(message = "First name must not be empty!")
    @Size(min = 2, message = "First name size must be more than 2 symbols!")
    private String firstName;

    @NotEmpty(message = "Last name must not be empty!")
    @Size(min = 2, message = "Last name size must be more than 2 symbols!")
    private String lastName;

    @NotNull(message = "Education level must be selected!")
    private EducationLevelEnum educationLevel;

    @NotNull(message = "Company must be selected!")
    private String companyName;

    @NotEmpty(message = "Must select job title!")
    private String jobTitle;

    @NotNull(message = "Birthdate is required!")
    private LocalDate birthDate;

    @NotNull(message = "Salary is required!")
    @Positive(message = "salary must be positive!")
    private BigDecimal salary;

    public java.lang.String getFirstName() {
        return firstName;
    }

    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    public java.lang.String getLastName() {
        return lastName;
    }

    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }

    public EducationLevelEnum getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevelEnum educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public java.lang.String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(java.lang.String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
