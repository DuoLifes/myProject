package com.connext.test.mongo.repository;

import com.connext.test.mongo.entity.Grade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends MongoRepository<Grade,String>{

}
