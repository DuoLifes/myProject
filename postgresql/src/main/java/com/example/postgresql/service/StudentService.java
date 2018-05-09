package com.example.postgresql.service;


import com.example.postgresql.entity.Student;
import com.example.postgresql.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Page<Student> Pageable(Pageable pageable){
        return studentRepository.findAll(pageable);
    }
}
