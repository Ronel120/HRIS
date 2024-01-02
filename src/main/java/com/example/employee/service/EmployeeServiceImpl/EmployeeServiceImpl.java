package com.example.employee.service.EmployeeServiceImpl;

import com.example.employee.entity.Employee;
import com.example.employee.exception.DataNotFoundException;
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

    EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeNumberGenerator employeeNumberGenerator){
        this.employeeRepository = employeeRepository;
        generator = employeeNumberGenerator;
    }

    @Override
    @Transactional
    public Employee add(Employee employee) {
        String employeeNumber = generator.generate();
        employee.setEmployeeNumber(employeeNumber);
        return employeeRepository.save(employee);
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
