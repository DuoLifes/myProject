package com.connext.test.redis.entity;

import java.io.Serializable;

public class Address implements Serializable {
    private String id;
    private String city;
    private String detail;


    public Address(String id, String city, String detail) {
        this.id = id;
        this.city = city;
        this.detail = detail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
