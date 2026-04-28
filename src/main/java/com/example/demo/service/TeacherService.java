package com.example.demo.service;

import com.example.demo.domain.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    List<Teacher> findAll();

    Optional<Teacher> findById(Long id);

    Teacher save(Teacher teacher);

    Teacher update (Long id, Teacher teacher);

    void deleteById(Long id);

    void deleteAll();
}
