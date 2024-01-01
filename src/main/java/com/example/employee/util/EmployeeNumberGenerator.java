package com.example.employee.util;

import com.example.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class EmployeeNumberGenerator {

    private final String dateStarted = String.valueOf(ZonedDateTime.now().getYear());

    private final EmployeeRepository repository;

    EmployeeNumberGenerator(EmployeeRepository employeeRepository) {
        repository = employeeRepository;
    }

    public String generate(){
        int totalEmployee = repository.findAll().size() + 1;
        String paddedNumber = String.format("%04d",totalEmployee);
        return dateStarted + "-" + paddedNumber;
    }

}
