package com.connext.kafka.kafka;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class KafkaReceiver {

//    @KafkaListener(topics = {"test"})
//    public void listen(ConsumerRecord<?, ?> record) {
//
//        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//
//        if (kafkaMessage.isPresent()) {
//
//            Object message = kafkaMessage.get();
//
//            System.out.println("----------------- record =" + record);
//            System.out.println("------------------ message =" + message);
//        }
//
//    }


    @KafkaListener(topics = {"test"})
    public void listen(String str) {
        //字符串转json对象
        JSONObject jo = JSON.parseObject(str);
        //方法：1    json对象转回实体
        Person person = JSONObject.toJavaObject(jo,Person.class);

        System.out.println("接收消息："+"姓名："+person.getName()+"=="+"性别："+person.getSex()+"=========================");
    }


}
