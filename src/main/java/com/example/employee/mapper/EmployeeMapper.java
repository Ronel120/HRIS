package com.example.employee.mapper;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto toDto(Employee employee);

    Employee toEntity(EmployeeDto employeeDto);

    @Mapping(target = "id", ignore = true)
    void updateEntity(EmployeeDto employeeDto, @MappingTarget Employee employee);
}
