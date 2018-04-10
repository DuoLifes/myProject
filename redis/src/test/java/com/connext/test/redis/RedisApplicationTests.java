package com.connext.test.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {


	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	@Test
	public void contextLoads() {
		try {
			redisTemplate.opsForValue().set("name2", "王五");
			Object object = redisTemplate.opsForValue().get("name");
			System.out.println(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
