package com.mikeshaggy.hms.repository;

import com.mikeshaggy.hms.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByUsername(String username);
    Boolean existsByUsername(String username);
}
