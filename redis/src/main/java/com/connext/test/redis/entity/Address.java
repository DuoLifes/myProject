package com.connext.test.redis.entity;

import java.io.Serializable;

public class Address implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String id;
    private String city;
    private String detail;

    public Address() {

    }

    public Address(String id, String city, String detail) {
        super();
        this.id = id;
        this.city = city;
        this.detail = detail;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     *            the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail
     *            the detail to set
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }
}
