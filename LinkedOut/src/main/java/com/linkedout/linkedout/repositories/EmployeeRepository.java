package com.linkedout.linkedout.repositories;

import com.linkedout.linkedout.models.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
