package com.example.demo.dto.student;

import com.example.demo.domain.entity.Parent;
import com.example.demo.domain.enums.Gender;
import com.example.demo.domain.enums.StudentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor //constructor ko có tham số
@AllArgsConstructor // 1 tham số chưa hết các trường này
public class StudentUpsertRequest {
    private String studentCode;

    private String fullName;

    private LocalDate dateOfBirth;

    private Gender gender = Gender.OTHER;

    private String gradeLevel;

    private String schoolName;

    private String phone;

    private String description;

    private Long parentId; // không truyền parent private Parent parent mà truyền id
                              // sự khác biệt đầu tiên
    private StudentStatus status = StudentStatus.ACTIVE;

    private BigDecimal latestScore = BigDecimal.ZERO;

    private String note;

    private String email;

    private String address;

//    private LocalDateTime createdAt; // upsert không có hai phần này, create vs update nó không truyền lên đc
//    private LocalDateTime updatedAt; // student không có mô tả relationship - quan hệ nhiều mộ
//    nên copy qua cho nhanh => không nên gõ lại => copy qua entity (làm 1 lần cho toàn dữ án, lâu lâu mới lm 1 lần)
}
