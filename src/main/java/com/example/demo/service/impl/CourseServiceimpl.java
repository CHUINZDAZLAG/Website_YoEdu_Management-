package com.example.demo.service.impl;

import com.example.demo.domain.entity.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CourseServiceimpl implements CourseService {
    private final CourseRepository courseRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Optional<Course> findById(Long id){
        return courseRepository.findById(id);
    }

    public Course save(Course course){
        return courseRepository.save(course);
    }
}
