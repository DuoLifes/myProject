package com.example.testrabbit.rabbit;

import java.io.Serializable;

public class City implements Serializable{

    private String id;
    private String name;
    private String detail;

    public  City(String id,String name,String detail){
        this.id=id;
        this.name=name;
        this.detail=detail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
