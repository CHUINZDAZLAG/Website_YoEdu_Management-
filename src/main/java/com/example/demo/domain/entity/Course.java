package com.example.demo.domain.entity;

import com.example.demo.domain.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Course extends AuditableEntity {
    //@Colum(name="course_code") //lưu dưới database đổi tên cột
    @Column(columnDefinition="varchar(20)")
    private String courseCode;

    @Column(columnDefinition = "varchar(100)")
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    private double tuitionFee;

    private int totalSessions;

    private byte isActive;
}
