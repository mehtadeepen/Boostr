package com.intuit.honeybadgers.boostr.db.tables;

import javax.annotation.Generated;

/**
 * Article is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class Article {

    private String category;

    private Integer id;

    private String url;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

