package com.linkedout.linkedout.repositories;

import com.linkedout.linkedout.models.dto.ExtractCompaniesDto;
import com.linkedout.linkedout.models.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
    Optional<Company> findByName(java.lang.String name);
}
