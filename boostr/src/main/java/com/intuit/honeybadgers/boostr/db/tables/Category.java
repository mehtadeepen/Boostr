package com.intuit.honeybadgers.boostr.db.tables;

import javax.annotation.Generated;

/**
 * Category is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class Category {

    private Integer id;

    private String name;

    private Integer user;

    private Long value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

}

