package com.example.postgresql.webapi;


import com.example.postgresql.entity.Student;
import com.example.postgresql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/jpa")
public class StudentApi {
    @Autowired
    private StudentService studentService;

    @GetMapping("/findAll")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/pageable")
    public Page<Student> Pageable(Pageable pageable){
        return studentService.Pageable(pageable);
    }
}
