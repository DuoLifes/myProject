package com.example.testrabbit.rabbit;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Receiver {
    @RabbitListener(queues = "spring-boot")
    public void receiveMessage(String str) {
        City city = JSON.parseObject(str,City.class);

        System.out.println("Received <" + city.getName()+city.getDetail()+">");
    }
}