package com.example.employee.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
@Data
@MappedSuperclass
public class RootEntity {


    @CreatedDate
    private LocalDateTime createdOn;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    private boolean deleted = Boolean.FALSE;
}
