package com.connext.kafka.kafka;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class PersonAPI {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping
    public String send(){
        Person person1=new Person("3","王萌萌","女",22);
        String str = JSON.toJSON(person1).toString();
        //JSONObject jo = JSON.parseObject(str);
        System.out.println("发送消息:"+str+"++++++++++++++++++++++");
        kafkaTemplate.send("test",str);
        return "success";
    }
}
