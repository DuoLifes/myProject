package com.connext.test.es.service;

import com.connext.test.es.entity.User;
import com.connext.test.es.repository.ElasticSearchRepository;
import com.connext.test.es.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ElasticSearchRepository elasticSearchRepository;

    //保存对象
    public User save(User user) {
        return userRepository.save(user);
    }

    //根据主键删除对象
    public void deleteByUserId(Integer userId) {
        userRepository.deleteById(userId);
    }

    //根据主键查询对象
    public Optional<User> findByUserId(Integer userId) { return userRepository.findById(userId); }

    //查询所有对象
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    //动态分页查询
    public Page<User> findByUserName(String userName, PageRequest pageRequest) { return userRepository.findByUserName(userName,pageRequest); }

    //根据手机号查询对象列表
    public List<User> findByUserPhone(String userPhone) {
        return userRepository.findByUserPhone(userPhone);
    }

    //创建索引插入
    public void addElasticsearch(String index,String type,List<User>list){
        elasticSearchRepository.batchCreate(index,type,list);
    }
}
