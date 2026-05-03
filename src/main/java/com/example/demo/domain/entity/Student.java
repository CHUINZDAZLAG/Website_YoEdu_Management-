package com.example.demo.domain.entity;

import com.example.demo.domain.AuditableEntity;
import com.example.demo.domain.enums.Gender;
import com.example.demo.domain.enums.StudentStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.sql.ast.tree.expression.JsonTableColumnDefinition;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "students")
public class Student extends AuditableEntity {

    @Column(name = "student_code", nullable = false, unique = true, length = 20)
    private String studentCode;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Gender gender = Gender.OTHER;

    @Column(name = "grade_level", length = 30)
    private String gradeLevel;

    @Column(name = "school_name", length = 100)
    private String schoolName;

    @Column(length = 20)
    private String phone;

    @Column(length = 255)
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StudentStatus status = StudentStatus.ACTIVE;

    @Column(name = "latest_score", precision = 5, scale = 2)
    private BigDecimal latestScore = BigDecimal.ZERO;

    @Column(length = 255)
    private String note;

    @Column(unique = true)
    private String email;

    @Column(columnDefinition = "varchar(255)")
    private String address;

}
    //Note ngắn ngắn là String còn dài là text => mỗi hệ cơ sở d liệu là text khác nhau vì mỗi hệ quản trị CSDL thì text khác nhau
    //Nên

