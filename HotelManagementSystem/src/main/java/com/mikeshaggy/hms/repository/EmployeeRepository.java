package com.mikeshaggy.hms.repository;

import com.mikeshaggy.hms.model.Employee;
import com.mikeshaggy.hms.repository.base.BaseRepository;

import java.util.Optional;

public interface EmployeeRepository extends BaseRepository<Employee, Long> {
    Optional<Employee> findByUsername(String username);
    Boolean existsByUsername(String username);
}
