package com.example.demo.service.impl;

import com.example.demo.domain.entity.Teacher;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceimpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }

    public Optional<Teacher> findById(Long id){
        return teacherRepository.findById(id);
    }

    public Teacher save(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public Teacher update(Long id, Teacher teacher){
        Teacher existingTeacher = teacherRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Teacher Not Found"));
        existingTeacher.setFullName(teacher.getFullName());
        existingTeacher.setEmail(teacher.getEmail());
        existingTeacher.setPhone(teacher.getPhone());
        return teacherRepository.save(existingTeacher);
    }

    @Override
    public void deleteById(Long id){
        teacherRepository.deleteById(id);
    }

    @Override
    public void deleteAll(){
        teacherRepository.deleteAll();
    }
}

