package com.example.testrabbit.rabbit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void send() {
        City city=new City("1","南京","六朝古都");

        String str = JSON.toJSON(city).toString();

        System.out.println("帅帅 发送消息...");
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, str);
    }


    public static void main(String[] args) {
        City city=new City("1","南京","六朝古都");

        String str = JSON.toJSON(city).toString();

        JSONObject jo = JSON.parseObject(str);
        System.out.println(jo);

        City city1 = JSONObject.toJavaObject(jo,City.class);
        System.out.println("city1:" + city1.getName());

        City city2 = JSON.parseObject(str,City.class);

        System.out.println("city2:" + city2.getName());

    }
}