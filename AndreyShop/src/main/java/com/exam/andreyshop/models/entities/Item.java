package com.exam.andreyshop.models.entities;

import com.exam.andreyshop.models.enums.GenderEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Entity
@Table(name = "items")
public class Item extends BaseEntity{

    @Column(unique = true, nullable = false)
    @Length(min = 2)
    private String name;

    @Column(columnDefinition = "TEXT")
    @Length(min = 3)
    private String description;

    @Positive
    @Column
    private BigDecimal price;

    @ManyToOne
    private Category category;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }
}
