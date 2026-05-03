package com.example.demo.controllers;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final StudentService studentService;


    @GetMapping("/")
    public ResponseEntity<List<Student>> hello() {
        return ResponseEntity.ok(studentService.findAll());
    }

}
