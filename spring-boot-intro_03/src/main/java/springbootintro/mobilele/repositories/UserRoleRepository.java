package springbootintro.mobilele.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springbootintro.mobilele.domain.entities.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {
}
