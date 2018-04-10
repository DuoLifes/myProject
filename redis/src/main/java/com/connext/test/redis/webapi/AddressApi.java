package com.connext.test.redis.webapi;

import com.connext.test.redis.entity.Address;
import com.connext.test.redis.service.AddressService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("rest_redis")
public class AddressApi {
    @Resource
    private AddressService addressService;

    @GetMapping("set")
    public void set() {
        addressService.set("key1", new Address("1","南京","雨花台区"));
    }
    @GetMapping("get")
    public String get() {
        return addressService.get("key1").getCity();
    }
    @GetMapping("stringset")
    public void stringset() {
        addressService.setCode("stringkey", "meepoguan_coke");
    }
    @GetMapping("stringget")
    public String stringget() {
        return addressService.getCode("stringkey");
    }
}
