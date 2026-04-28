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

    public Course save(Course Course){
        return courseRepository.save(Course);
    }

    @Override
    public Course update(Long id, Course Course){
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Course Not Found"));
        existingCourse.setName(Course.getName());
        existingCourse.setDescription(Course.getDescription());
        existingCourse.setCourseCode(Course.getCourseCode());
        existingCourse.setTuitionFee(Course.getTuitionFee());
        existingCourse.setTotalSessions(Course.getTotalSessions());
        return courseRepository.save(existingCourse);
    }

    @Override
    public void deleteById(Long id){
        courseRepository.deleteById(id);;
    }

    @Override
    public void deleteAll(){
        courseRepository.deleteAll();
    }

}
