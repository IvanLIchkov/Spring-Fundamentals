package com.exam.battleships.models.dtos;

import com.exam.battleships.models.entities.Category;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class AddShipDto {

    @NotEmpty(message = "Name must not be empty!")
    @Size(min = 2, max = 10, message = "Name must be between 2 and 10 symbols!")
    private String name;

    @NotNull(message = "Health must nit be empty!")
    @Positive(message = "Health must be positive number!")
    private Long health;

    @NotNull(message = "Power must nit be empty!")
    @Positive(message = "Power must be positive number!")
    private Long power;

    @Past(message = "Date must be in past!")
    private LocalDate created;

    @NotNull(message = "Category must be selected!")
    private Category category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
