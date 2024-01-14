package com.example.employee.dto;

import com.example.employee.entity.ContactInfo;
import com.example.employee.entity.Name;
import com.example.employee.enums.Department;
import lombok.Data;

@Data
public class EmployeeDto {

    private Long id;
    private String employeeNumber;
    private Name name;
    private ContactInfo contactInfo;
    private Department department;


}
