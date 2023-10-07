package com.linkedout.linkedout.models.entity;

import com.linkedout.linkedout.models.enums.EducationLevelEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee extends BaseEntity{

    @Column(nullable = false)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private EducationLevelEnum educationLevel;

    @Column(nullable = false)
    @Size(min = 2)
    private java.lang.String firstName;

    @Column(nullable = false)
    @Size(min = 2)
    private java.lang.String lastname;

    @Column(nullable = false)
    private java.lang.String jobTitle;

    @Column(nullable = false)
    @Positive
    private BigDecimal salary;

    @ManyToOne
    private Company company;

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    public EducationLevelEnum getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevelEnum educationLevel) {
        this.educationLevel = educationLevel;
    }

    public java.lang.String getFirstName() {
        return firstName;
    }

    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    public java.lang.String getLastname() {
        return lastname;
    }

    public void setLastname(java.lang.String lastname) {
        this.lastname = lastname;
    }

    public java.lang.String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(java.lang.String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
