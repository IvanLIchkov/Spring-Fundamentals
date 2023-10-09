package com.exam.shoppinglist.models.entities;

import com.exam.shoppinglist.models.enums.CategoryTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String name;


    private String description;

    public Category() {
    }

    public Category(CategoryTypeEnum categoryTypeEnum) {
        this();
        this.name = categoryTypeEnum.name();
    }

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
}
