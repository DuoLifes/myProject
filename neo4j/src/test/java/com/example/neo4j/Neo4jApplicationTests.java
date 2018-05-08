package com.example.neo4j;

import com.example.neo4j.entity.Student;
import com.example.neo4j.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Neo4jApplicationTests {

	@Autowired
	private StudentRepository studentRepository;
	@Test
	public void contextLoads() {
		Student student=new Student("王五","男");
		studentRepository.save(student);
	}

}
