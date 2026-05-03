package com.example.demo.domain.entity;

import com.example.demo.domain.AuditableEntity;
import com.example.demo.domain.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "parents")
public class Parent extends AuditableEntity {

    @Column(name = "full_name", columnDefinition = "varchar(100)", nullable = false)
    private String fullName;
    @Column(unique = true, nullable = false)
    private String phone;
    @Column(unique = true)
    private String email;
    @Column(columnDefinition = "varchar(255)")
    private String address;
    @Column(length = 20)
    private String relationship;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Gender gender;

}
