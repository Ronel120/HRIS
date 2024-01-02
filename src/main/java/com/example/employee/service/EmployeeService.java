package com.example.employee.service;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.entity.Employee;
import com.example.employee.exception.DataNotFoundException;

import java.util.List;

public interface EmployeeService {

    EmployeeDto add(EmployeeDto employeeDto);

    List<Employee> list();

    Employee update(Long id, Employee employee) throws DataNotFoundException;

    void delete(Long id) throws DataNotFoundException;
}
