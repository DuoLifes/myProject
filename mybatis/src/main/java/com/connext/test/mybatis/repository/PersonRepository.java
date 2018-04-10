package com.connext.test.mybatis.repository;


import com.connext.test.mybatis.domain.PageAble;
import com.connext.test.mybatis.domain.PageInfo;
import com.connext.test.mybatis.entity.Person;

import java.util.List;
import java.util.Map;

//@Mapper
public interface PersonRepository {
//    @Select("select * from person")
    List<Person> findAll();
    public void add();

    public int findCount();

    public PageInfo<Person> findPage(Map<String, Object> map);

    public List<Person> findByPage(Map<String, Object> map);

    public List<Person> PageAble(PageAble pageAble);
}
