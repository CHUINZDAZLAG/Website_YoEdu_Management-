package com.example.demo.controllers;

import com.example.demo.common.ApiResponse;
import com.example.demo.domain.entity.Course;
import com.example.demo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getCourse (){
        return ResponseEntity.ok(ApiResponse.success(courseService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById (@PathVariable Long id){
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

    @PostMapping
    public ResponseEntity<ApiResponse<Course>> createCourse(@RequestBody Course Course){
        Course newCourse = courseService.save(Course);
        return ResponseEntity.ok((ApiResponse.success(newCourse)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> updateCourse(@PathVariable Long id, @RequestBody Course Course){
        Optional <Course> existingCourse = courseService.findById(id);

        if(existingCourse.isPresent()){
            Course updatedCourse = courseService.update(id, Course);
            return ResponseEntity.ok(ApiResponse.success(updatedCourse));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteCourse(@PathVariable Long id){
        Optional<Course> existingCourse = courseService.findById(id);

        if(existingCourse.isPresent()){
            courseService.deleteById(id);
            return ResponseEntity.ok(
                    ApiResponse.success("This course has been deleted")
            );
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/all")
    public ResponseEntity<ApiResponse<String>> deleteAllCourse(){
        courseService.deleteAll();
        return ResponseEntity.ok(ApiResponse.success("All courses have been deleted successfully"));
    }


}
