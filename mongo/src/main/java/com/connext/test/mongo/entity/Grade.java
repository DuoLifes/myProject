package com.connext.test.mongo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

//测试mongodb
@Document
public class Grade {
    private String id;
    private String gradeName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
}
