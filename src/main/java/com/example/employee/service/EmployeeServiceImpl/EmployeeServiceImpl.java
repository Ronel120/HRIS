package com.example.employee.service.EmployeeServiceImpl;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.entity.Employee;
import com.example.employee.exception.DataNotFoundException;
import com.example.employee.mapper.EmployeeMapper;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;
import com.example.employee.util.EmployeeNumberGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeNumberGenerator generator;

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper mapper;

    EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeNumberGenerator employeeNumberGenerator, EmployeeMapper employeeMapper){
        this.employeeRepository = employeeRepository;
        generator = employeeNumberGenerator;
        mapper = employeeMapper;
    }

    @Override
    @Transactional
    public EmployeeDto add(EmployeeDto employeeDto) {
        String employeeNumber = generator.generate();
        employeeDto.setEmployeeNumber(employeeNumber);
        Employee employee = mapper.toEntity(employeeDto);
        return mapper.toDto(employeeRepository.save(employee));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> list() {
        return employeeRepository.findAllByDeletedIsFalse();
    }

    @Override
    @Transactional
    public Employee update(Long id, Employee employee) throws DataNotFoundException {
        Employee employee1 = employeeRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("Data not found"));
        employee1.setName(employee.getName());
        return employeeRepository.save(employee1);
    }

    @Override
    @Transactional
    public void delete(Long id) throws DataNotFoundException{
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("Data not found"));
        employee.setDeleted(true);
        employeeRepository.save(employee);
    }
}
