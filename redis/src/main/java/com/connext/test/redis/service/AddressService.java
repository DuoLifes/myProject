package com.connext.test.redis.service;

import com.connext.test.redis.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    //插入对象
    public void set(String key, Address address) {
        redisTemplate.opsForValue().set(key, address);
    }
    //获取对象
    public Address get(String key) {
        return (Address) redisTemplate.boundValueOps(key).get();
    }

    //删除对象
    public void delete(String key) {
        redisTemplate.delete(key);
    }


}
