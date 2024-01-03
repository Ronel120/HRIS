package com.example.employee.entity;


import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;

@Embeddable
@Data
public class ContactInfo {

    private String contactNumber;
    private String email;
}
