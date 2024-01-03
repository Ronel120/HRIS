package com.example.employee.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

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





}
