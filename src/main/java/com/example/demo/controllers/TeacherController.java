package com.example.demo.controllers;

import com.example.demo.common.ApiResponse;
import com.example.demo.domain.entity.Course;
import com.example.demo.domain.entity.Teacher;
import com.example.demo.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Teacher>>> getCourse(){
        return ResponseEntity.ok(ApiResponse.success(teacherService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Teacher>> getCourseById (@PathVariable Long id){
        Optional<Teacher> teacher = teacherService.findById(id);

        if(teacher.isPresent()){
            return ResponseEntity.ok((ApiResponse.success(teacher.get())));
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Teacher>> createTeacher ( @RequestBody Teacher teacher){
        Teacher newTeacher = teacherService.save(teacher);
        return ResponseEntity.ok(ApiResponse.success(newTeacher));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Teacher>> updateTeacher (@PathVariable Long id, @RequestBody Teacher teacher){
        Optional<Teacher> existingTeacher = teacherService.findById(id);
        if(existingTeacher.isPresent()){
            Teacher updatedTeacher = teacherService.save(teacher);
            return ResponseEntity.ok(ApiResponse.success(updatedTeacher));
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteTeacher (@PathVariable Long id){
        Optional<Teacher> existingTeacher = teacherService.findById(id);
        if(existingTeacher.isPresent()){
            teacherService.deleteById(id);
            return ResponseEntity.ok(ApiResponse.success("Teacher has been delelted successfully"));
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/all")
    public ResponseEntity<ApiResponse<String>> deleteAllTeacher(){
        teacherService.deleteAll();
        return ResponseEntity.ok(ApiResponse.success("Teachers have been deleted successfully"));
    }
}
