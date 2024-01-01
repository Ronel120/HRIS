package com.example.employee.controller;

import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.util.EmployeeNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    private final EmployeeNumberGenerator generator;

    @Autowired
    EmployeeController(EmployeeRepository repository, EmployeeNumberGenerator generator1) {
        employeeRepository = repository;
        generator = generator1;
    }

    @PostMapping
    public ResponseEntity<Employee> add(@RequestBody Employee employee) {
        String employeeNumber = generator.generate();
        employee.setEmployeeNumber(employeeNumber);
        return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.OK);
    }




}
