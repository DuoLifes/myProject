package com.connext.kafka.kafka;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@Slf4j
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    //发送消息方法
    public void send() {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        System.out.println("发送消息："+gson.toJson(message));
        kafkaTemplate.send("test", gson.toJson(message));
    }


    public void mySend(){
        //Person person=new Person("1","王思雨","女",25);
        Person person1=new Person("2","张帅","男",25);
        String str = JSON.toJSON(person1).toString();
        //JSONObject jo = JSON.parseObject(str);
        System.out.println("发送消息:"+str+"++++++++++++++++++++++");
        kafkaTemplate.send("test",str);
    }
}