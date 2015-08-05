package com.intuit.honeybadgers.boostr.db.tables;

import javax.annotation.Generated;

/**
 * DbCategoryData is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class DbCategoryData {

    private String name;

    private String user;

    private Float value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

}

