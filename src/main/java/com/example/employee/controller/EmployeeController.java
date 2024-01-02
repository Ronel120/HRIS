package com.example.employee.controller;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeRepository;

    @Autowired
    EmployeeController(EmployeeService employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping
    public ResponseEntity<Employee> add(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeRepository.add(employee), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> list() {
        return new ResponseEntity<>(employeeRepository.list(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") Long id,
                                           @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeRepository.update(id, employee), HttpStatus.OK);

    }


}
