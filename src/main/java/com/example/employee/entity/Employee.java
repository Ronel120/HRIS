package com.example.employee.entity;

import com.example.employee.enums.Department;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;

@Table(name = "employee")
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Employee extends RootEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String employeeNumber;

    private Name name;

    private ContactInfo contactInfo;

    @Enumerated(EnumType.STRING)
    private Department department;

    private String address;

    private BigDecimal salaryGrade;

    private BigDecimal salaryBase;
}
