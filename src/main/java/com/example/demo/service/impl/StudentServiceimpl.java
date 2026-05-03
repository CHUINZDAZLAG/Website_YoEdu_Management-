package com.example.demo.service.impl;

import com.example.demo.common.exception.NotFoundException;
import com.example.demo.domain.entity.Parent;
import com.example.demo.domain.entity.Student;
import com.example.demo.dto.parent.ParentResponse;
import com.example.demo.dto.student.StudentResponse;
import com.example.demo.dto.student.StudentUpsertRequest;
import com.example.demo.repository.ParentRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class StudentServiceimpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ParentRepository parentRepository;
    private final ModelMapper mapper;

    private StudentResponse map(Student student){
        return mapper.map(student, StudentResponse.class);
    }


    public List<StudentResponse> findByAll() {
        return studentRepository.findAll().stream()
                .map(this::map)
                .toList();
    }

    //public StudentResponse findById(Long id){
        /*Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student
        } eslse{Ơ
         **/

    public Optional<StudentResponse> findById(Long id){
        return studentRepository.findById(id)
                .map(this::map);
    }

    public StudentResponse create(StudentUpsertRequest req){
        Student stu = mapper.map(req, Student.class);
        //stu.setId(id);
        parentRepository.findById(req.getParentId())
                .ifPresent(p->stu.setParent(p));
        stu.setCreatedAt(LocalDateTime.now());
        stu.setUpdatedAt(LocalDateTime.now());
        Student result = studentRepository.save(stu);
        return map(result);
    }

    public StudentResponse update(Long id, StudentUpsertRequest req){
        Student stu = mapper.map(req, Student.class);
        //stu.setId(id);
        parentRepository.findById(req.getParentId())
                .ifPresent(p->stu.setParent(p));
        stu.setCreatedAt(LocalDateTime.now());
        stu.setUpdatedAt(LocalDateTime.now());
        Student result = studentRepository.save(stu);
        return map(result);

    }
    public void delete(Long id) throws NotFoundException {
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
        } else{
            throw new NotFoundException("Delete error");
        }
    }
    //STRICT xài đúng tên sẽ không map sai va bị các lỗi như v

  //private StudentResponse map(Student student)


    /*private StudentResponse map(Student student) {
        StudentResponse result = new StudentResponse();
        ParentResponse pResult = new ParentResponse();

        if (student.getParent() != null) {
            pResult.setFullName(student.getParent().getFullName());
            pResult.setPhone(student.getParent().getPhone());
            pResult.setEmail(student.getParent().getEmail());
            pResult.setAddress(student.getParent().getAddress());
            pResult.setRelationship(student.getParent().getRelationship());
            pResult.setGender(student.getParent().getGender());
        }

        result.setId(student.getId());
        result.setStudentCode(student.getStudentCode());
        result.setFullName(student.getFullName());
        result.setDateOfBirth(student.getDateOfBirth());
        result.setGender(student.getGender());
        result.setGradeLevel(student.getGradeLevel());
        result.setSchoolName(student.getSchoolName());
        result.setPhone(student.getPhone());
        result.setDescription(student.getDescription());
        result.setParent(pResult);
        result.setStatus(student.getStatus());
        result.setLatestScore(student.getLatestScore());
        result.setNote(student.getNote());

        return result;
    }*/

}