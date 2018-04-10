package com.connext.test.mybatis.webapi;



import com.connext.test.mybatis.BaseCache;
import com.connext.test.mybatis.domain.PageAble;
import com.connext.test.mybatis.domain.PageInfo;
import com.connext.test.mybatis.entity.Person;
import com.connext.test.mybatis.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/mybatis")
public class PersonApi {
    @Autowired
    private PersonService personService;

    @Autowired
    private BaseCache baseCache;

    @GetMapping("/findAll")
    public List<Person> findAll(){
        return personService.findAll();
    }

    @GetMapping("/hashtable")
    public Hashtable<String,Person> personHashtable(){
        return personService.personHashtable();
    }

    @GetMapping("/add")
    public String add(){
        personService.add();
        baseCache.clearPersonHashtable();
        return "success";
    }

    @GetMapping("/findBypage")
    public PageInfo<Person> findByPage(@RequestParam Integer page,@RequestParam Integer size){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("page",page);
        map.put("size",size);
        return personService.findByPage(map);
    }

    @GetMapping("/PageAble")
    public List<Person> PageAble(@RequestParam Integer page,@RequestParam Integer size){
        PageAble pageAble=new PageAble();
        pageAble.setPage(page);
        pageAble.setSize(size);
        pageAble.setBegin((page-1)*size);
        return personService.PageAble(pageAble);
    }
}
