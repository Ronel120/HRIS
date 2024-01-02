package com.example.employee.dto;

import com.example.employee.entity.Name;
import lombok.Data;

@Data
public class EmployeeDto {

    private Long id;
    private String employeeNumber;
    private Name name;

}
