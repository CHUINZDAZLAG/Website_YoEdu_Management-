package com.example.demo.domain.entity;

import com.example.demo.domain.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "parents")
public class Parent extends AuditableEntity {
    @Column(columnDefinition="varchar(100)")
    private String full_name;

    @Column(columnDefinition="varchar(20)")
    private String phone;

    @Column(columnDefinition="varchar(20)")
    private String email;

    @Column(columnDefinition="varchar(20)")
    private String address;
}
