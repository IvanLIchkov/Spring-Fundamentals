package com.example.pathfinder.models.entities;

import com.example.pathfinder.models.enums.RoleTypes;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Column
    @Enumerated(EnumType.STRING)
    private RoleTypes role;


    public Role() {
    }

    public RoleTypes getRole() {
        return role;
    }

    public Role setRole(RoleTypes name) {
        this.role = name;
        return this;
    }
}
