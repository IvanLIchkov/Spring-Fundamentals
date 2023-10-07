package com.linkedout.linkedout.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "companies")
public class Company extends BaseEntity {

    @Column(nullable = false)
    @Positive
    private BigDecimal budget;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    @Size(min = 10)
    private java.lang.String description;

    @Column(unique = true, nullable = false)
    @Size(min = 2, max = 10)
    private java.lang.String name;

    @Column(nullable = false)
    @Size(min = 2, max = 10)
    private java.lang.String town;

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public java.lang.String getDescription() {
        return description;
    }

    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getTown() {
        return town;
    }

    public void setTown(java.lang.String town) {
        this.town = town;
    }
}
