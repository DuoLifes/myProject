package com.example.testrabbit;

import com.example.testrabbit.rabbit.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestrabbitApplicationTests {

	@Autowired

	private Sender send;
	@Test
	public void contextLoads() {
		System.out.println("==========发送消息！");
		send.send();
	}

}
