package com.korit.springboot.service;

import com.korit.springboot.domain.entity.StudentEntity;
import com.korit.springboot.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentEntity register(StudentEntity student) {
        return studentRepository.save(student);
    }

    public List<StudentEntity> getAll(){
        return studentRepository.findAll();
    }

    public Boolean remove(Integer studentId){
        studentRepository.deleteById(studentId);
        return true;
    }
}
