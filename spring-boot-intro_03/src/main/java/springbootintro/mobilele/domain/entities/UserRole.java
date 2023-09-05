package springbootintro.mobilele.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import springbootintro.mobilele.domain.enums.RoleTypes;

@Entity
@Table(name = "user_roles")
public class UserRole extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private RoleTypes role;

    public UserRole() {
    }

    public RoleTypes getRole() {
        return role;
    }

    public void setRole(RoleTypes role) {
        this.role = role;
    }
}
