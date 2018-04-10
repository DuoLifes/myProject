package com.connext.test.mybatis;

import com.connext.test.mybatis.entity.Person;
import com.connext.test.mybatis.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

	@Autowired
	private PersonRepository personRepository;
	@Test
	public void contextLoads() {
		List<Person> list=personRepository.findAll();
		System.out.print(list.get(0).getName());
	}

}
