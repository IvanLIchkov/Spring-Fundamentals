package com.exam.shoppinglist.models.dtos;

import com.exam.shoppinglist.models.validations.ProductNameMatch;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddDto {

    @NotEmpty(message = "Field must not be empty!")
    @Size(min = 3, max = 20, message = "Name size must be between 3 and 20 symbols!")
    @ProductNameMatch
    private String name;

    @NotEmpty(message = "Field must not be empty")
    @Size(min = 5, message = "Description size must be at least 5 symbols!")
    private String description;

    @Future(message = "Date must be from future!")
    @NotNull(message = "Field must not be empty!")
    private LocalDateTime before;

    @NotNull(message = "Field must not be empty!")
    @Positive(message = "Price must be positive number")
    private BigDecimal price;

    @NotNull(message = "Field must not be empty!")
    private Long categoryId;

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

    public LocalDateTime getBefore() {
        return before;
    }

    public void setBefore(LocalDateTime before) {
        this.before = before;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
