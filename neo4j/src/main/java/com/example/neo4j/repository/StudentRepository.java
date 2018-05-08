package com.example.neo4j.repository;

import com.example.neo4j.entity.Student;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface StudentRepository extends Neo4jRepository<Student,String> {
}
