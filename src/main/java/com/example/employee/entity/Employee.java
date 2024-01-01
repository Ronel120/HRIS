package com.example.employee.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Table(name = "employee")
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Employee extends RootEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "employeeNumber",unique = true)
    private String employeeNumber;

    @Embedded
    @Column(name = "name")
    private Name name;


}
