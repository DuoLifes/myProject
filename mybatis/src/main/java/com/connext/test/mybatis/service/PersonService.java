package com.connext.test.mybatis.service;


import com.connext.test.mybatis.BaseCache;
import com.connext.test.mybatis.domain.PageAble;
import com.connext.test.mybatis.domain.PageInfo;
import com.connext.test.mybatis.entity.Person;
import com.connext.test.mybatis.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BaseCache baseCache;

    public List<Person> findAll(){
        return personRepository.findAll();
    }


    public Hashtable<String,Person> personHashtable(){
        return baseCache.personHashtable();
    }


    public void add(){
        personRepository.add();
    }


    //分页查询1
    public PageInfo<Person> findByPage(Map<String, Object> map) {
        PageInfo<Person>info=new PageInfo<Person>();
        int count =personRepository.findCount();
        int pageIndex=(Integer)map.get("page");
        int size=(Integer)map.get("size");
        info.setCount(count);
        info.setSize(size);
        int total=info.getTotal();
        if(pageIndex>total) {
            pageIndex=total;
        }
        if(pageIndex<1) {
            pageIndex=1;
        }
        map.put("begin",(pageIndex-1)*info.getSize());
        map.put("size",info.getSize());
        List<Person> list=personRepository.findByPage(map);
        info.setList(list);
        return info;
    }


    //分页查询2
    public List<Person> PageAble(PageAble pageAble){
        return personRepository.PageAble(pageAble);
    }
}
