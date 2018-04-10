package com.connext.test.mybatis;


import com.connext.test.mybatis.entity.Person;
import com.connext.test.mybatis.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Hashtable;
import java.util.List;

@Slf4j
@Component
public class BaseCache {
    @Autowired
    private PersonRepository personRepository;

    @Cacheable("com.connext.test.mybatis.entity.Person")
    public Hashtable<String,Person> personHashtable(){
        Hashtable<String,Person>personHashtable=new Hashtable<>();
        List<Person> list=personRepository.findAll();
        log.info("开始加载缓存。。。"+ LocalTime.now().toString());
        list.forEach(person -> personHashtable.put(person.getId(),person));
        log.info("加载结束"+ LocalTime.now().toString());
        return personHashtable;
    }

    @CacheEvict("com.connext.test.mybatis.entity.Person")
    public void clearPersonHashtable() {

    }
    public void clearPerson() {
        clearPersonHashtable();
    }


}
