package com.example.demo.dto.student;

import com.example.demo.domain.entity.Parent;
import com.example.demo.domain.enums.Gender;
import com.example.demo.domain.enums.StudentStatus;
import com.example.demo.dto.parent.ParentResponse;
import com.example.demo.repository.ParentRepository;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class StudentResponse {
    private Long id;

    private String studentCode;

    private String fullName;

    private LocalDate dateOfBirth;

    private Gender gender = Gender.OTHER;

    private String gradeLevel;

    private String schoolName;

    private String phone;

    private String description;

    private ParentResponse parent;// không id mà parent vì chúng t dùng auto mapping
    // list student thì không lòa EAGER (tốn ram nhưng nhanh)
    //load parent tốn ram không bao nhiêu (đối tượng parent gắn đối tượng student thì ko nhiều
    //=> ngược lại thì nặng
    //Bài này Eager là được
    //Còn shoppee load hàng triệu sp (all danh mục)=> thì fail
    //EAGER bỏ đi được

    private StudentStatus status = StudentStatus.ACTIVE;

    private BigDecimal latestScore = BigDecimal.ZERO;

    private String note;

    private String email;

    private String address;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
