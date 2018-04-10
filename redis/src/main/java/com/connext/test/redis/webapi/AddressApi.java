package com.connext.test.redis.webapi;

import com.connext.test.redis.entity.Address;
import com.connext.test.redis.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class AddressApi {
    @Resource
    private AddressService addressService;

    @GetMapping("set")
    public void set() {
        addressService.set("key2", new Address("2","北京","朝阳区"));
    }
    @GetMapping("get")
    public String get() {
        return addressService.get("key1").getCity();
    }
    @GetMapping("delete")
    public String delete(@RequestParam String key) {
        addressService.delete(key);
        return "success";
    }

}
