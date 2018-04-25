package com.connext.kafka.kafka;

public class Person {

    private String id;
    private String name;
    private String sex;
    private Integer age;

    public Person (String id,String name,String sex,Integer age){
        this.id=id;
        this.name=name;
        this.sex=sex;
        this.age=age;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
