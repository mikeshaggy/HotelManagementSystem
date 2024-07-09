package com.mikeshaggy.hms.controller;

import com.mikeshaggy.hms.controller.base.BaseRestController;
import com.mikeshaggy.hms.model.Employee;
import com.mikeshaggy.hms.service.entity.EmployeeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController extends BaseRestController<Employee, Long> {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        super(employeeService);
        this.employeeService = employeeService;
    }
}
