package com.exam.battleships.models.entities;

import com.exam.battleships.models.enums.ShipNamesEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private ShipNamesEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category() {
    }

    public Category(ShipNamesEnum name){
        this.name = name;
    }

    public ShipNamesEnum getName() {
        return name;
    }

    public void setName(ShipNamesEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
