package com.example.employee.service;

import com.example.employee.entity.Employee;
import com.example.employee.exception.DataNotFoundException;

import java.util.List;

public interface EmployeeService {

    Employee add(Employee employee);

    List<Employee> list();

    Employee update(Long id, Employee employee) throws DataNotFoundException;

    void delete(Long id) throws DataNotFoundException;
}
