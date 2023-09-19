package com.example.pathfinder.models.entities;

import com.example.pathfinder.models.enums.RouteCategoryEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private RouteCategoryEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category() {
    }

    public RouteCategoryEnum getName() {
        return name;
    }

    public Category setName(RouteCategoryEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
