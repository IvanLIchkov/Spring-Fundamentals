package com.linkedout.linkedout.models.dto;

import com.linkedout.linkedout.models.validation.UniqueCompanyName;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class AddCompanyDto {

    @NotEmpty(message = "Town name must not be empty!")
    @Size(min = 2, max = 10, message = "Name must be between 2 and 10 symbols!")
    @UniqueCompanyName
    private String name;

    @NotEmpty(message = "Town name must not be empty!")
    @Size(min = 2, max = 10, message = "Town Name must be between 2 and 10 symbols!")
    private String town;

    @NotEmpty(message = "Description must not be empty!")
    @Size(min = 10, message = "Description must contain at least 10 symbols!")
    private String description;

    @Positive(message = "Budged must be positive number!")
    @NotNull(message = "Budget must be declared!")
    private BigDecimal budget;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
