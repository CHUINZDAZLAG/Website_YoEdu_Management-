package com.example.demo.service;

import com.example.demo.domain.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> findAll();

    Optional<Course> findById(Long id);

    Course save(Course Course);

    Course update(Long id, Course Course);

    void deleteById(Long id);

    void deleteAll();
}
