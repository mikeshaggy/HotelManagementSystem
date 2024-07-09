package com.mikeshaggy.hms.service.entity;

import com.mikeshaggy.hms.model.Employee;
import com.mikeshaggy.hms.repository.EmployeeRepository;
import com.mikeshaggy.hms.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends BaseService<Employee, Long> {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        super(employeeRepository);
        this.employeeRepository = employeeRepository;
    }

    @Override
    protected Class<Employee> getEntityClass() {
        return Employee.class;
    }
}
