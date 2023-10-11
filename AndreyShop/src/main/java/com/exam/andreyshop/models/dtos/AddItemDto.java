package com.exam.andreyshop.models.dtos;

import com.exam.andreyshop.models.enums.GenderEnum;
import com.exam.andreyshop.models.validations.ItemNameMatch;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class AddItemDto {

    @ItemNameMatch
    @Size(min = 2, message = "Name size must be at least 2 symbols!")
    @NotEmpty(message = "Required field!")
    private String name;

    @NotEmpty(message = "Required field!")
    @Size(min = 3, message = "Description size must be at least 3 symbols!")
    private String description;

    @NotNull(message = "Required field!")
    private Long categoryId;

    @NotNull(message = "Required field!")
    private GenderEnum gender;

    @NotNull(message = "Required field!")
    @Positive(message = "Price must be positive number!")
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
