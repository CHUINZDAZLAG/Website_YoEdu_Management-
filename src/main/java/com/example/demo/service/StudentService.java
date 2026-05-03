package com.example.demo.service;

import com.example.demo.common.exception.NotFoundException;
import com.example.demo.domain.entity.Student;
import com.example.demo.dto.student.StudentResponse;
import com.example.demo.dto.student.StudentUpsertRequest;
import com.example.demo.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<StudentResponse> findByAll();
    Optional<StudentResponse> findById(Long id);
    StudentResponse create(StudentUpsertRequest student);
    StudentResponse update(Long id, StudentUpsertRequest student);
    //hàm save ko có trg khóa chính id => tạo ms còn đưa vào trg id => nó sẽ update
    //gom hay tách thành hai hàm thì tùy ng lập tình
    void delete(Long id) throws NotFoundException;
}
