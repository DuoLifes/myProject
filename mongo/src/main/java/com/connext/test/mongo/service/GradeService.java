package com.connext.test.mongo.service;


import com.connext.test.mongo.entity.Grade;
import com.connext.test.mongo.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    public List<Grade> findAll(){
        return gradeRepository.findAll();
    }

    public Grade addGrade(Grade grade){
        return gradeRepository.save(grade);
    }
}
