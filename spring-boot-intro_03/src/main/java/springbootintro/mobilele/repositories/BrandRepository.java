package springbootintro.mobilele.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springbootintro.mobilele.domain.entities.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {
}
