package com.connext.test.redis.service;

import com.connext.test.redis.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class AddressService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
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



    public void setCode(String key, String code) {
        stringRedisTemplate.opsForValue().set(key, code, 60, TimeUnit.SECONDS);
    }
    public String getCode(String key) {
        return stringRedisTemplate.boundValueOps(key).get();
    }
}
