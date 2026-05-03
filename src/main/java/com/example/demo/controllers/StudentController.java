package com.example.demo.controllers;

import com.example.demo.domain.entity.Student;
import com.example.demo.dto.student.StudentResponse;
import com.example.demo.dto.student.StudentUpsertRequest;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/students")
public class StudentController {

    private final StudentService studentService;


    @GetMapping
    public ResponseEntity<List<StudentResponse>> findAll() {
        return ResponseEntity.ok(studentService.findByAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StudentResponse> findById(@PathVariable Long id){
        return studentService.findById(id)
                .map(stu-> ResponseEntity.ok(stu))
                .orElse(ResponseEntity.notFound().build());// trả về lỗi 401 ko phải exc
    }

    @PostMapping
    public ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentUpsertRequest req){ //Valid đứng tai đây để chặn request không hợp lệ
        return ResponseEntity.ok(studentService.create(req));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<StudentResponse> update(@PathVariable Long id, @RequestBody StudentUpsertRequest req){
        return ResponseEntity.ok(studentService.update(id, req));
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        // dấu chấm hỏi truyền vô gì cái gì cũng đc
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }

}
