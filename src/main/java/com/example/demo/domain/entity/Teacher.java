package com.example.demo.domain.entity;

import com.example.demo.domain.AuditableEntity;
import com.example.demo.domain.enums.TeacherRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "teachers")
public class Teacher extends AuditableEntity {
    @Column(columnDefinition="varchar(20)")
    private String teacherCode;

    @Column(columnDefinition="varchar(100)")
    private String fullName;

    @Column(columnDefinition = "varchar(20)")
    private String email;

    @Column(columnDefinition = "varchar(100)")
    private String phone;

    @Enumerated(EnumType.STRING)
    private TeacherRole teacherRole = TeacherRole.TEACHER;
}
