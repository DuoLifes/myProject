package com.connext.test.es.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = "frank", type = "user")
public class User implements Serializable {
    @Id
    private Integer id;
    private String userName;
    private String userPhone;
    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public User(Integer id, String userName, String userPhone) {
        this.id = id;
        this.userName = userName;
        this.userPhone = userPhone;
    }

}