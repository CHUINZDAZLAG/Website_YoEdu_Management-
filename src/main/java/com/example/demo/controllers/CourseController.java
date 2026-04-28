package com.example.demo.controllers;

import com.example.demo.common.ApiResponse;
import com.example.demo.domain.entity.Course;
import com.example.demo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    public ResponseEntity<ApiResponse<List<Course>>> getCourse (){
        return ResponseEntity.ok(ApiResponse.success(courseService.findAll()));
    }

    public ResponseEntity<ApiResponse<Course>> getCourseById (Long id){
        Optional<Course> course = courseService.findById(id);
  //      return course.map(value->
  //              ResponseEntity.ok(ApiResponse.success(value)))
  //              .orElseGet(()->ResponseEntity.notFound().build());

        if(course.isPresent()){
            return ResponseEntity.ok((ApiResponse.success(course.get())));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
