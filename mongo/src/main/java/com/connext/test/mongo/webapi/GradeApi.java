package com.connext.test.mongo.webapi;

import com.connext.test.mongo.entity.Grade;
import com.connext.test.mongo.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mongo")
public class GradeApi {
    @Autowired
    private GradeService gradeService;

    @GetMapping("/findAll")
    public List<Grade> findAll(){
        return gradeService.findAll();
    }

    @PostMapping
    public Grade addGrade(@RequestBody Grade grade){
        return gradeService.addGrade(grade);
    }
}
