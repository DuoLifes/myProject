package com.connext.kafka;

import com.connext.kafka.kafka.KafkaSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaApplicationTests {

	@Autowired
	private KafkaSender kafkaSender;
	@Test
	public void contextLoads() {
		//kafkaSender.send();
		kafkaSender.mySend();
	}

}
