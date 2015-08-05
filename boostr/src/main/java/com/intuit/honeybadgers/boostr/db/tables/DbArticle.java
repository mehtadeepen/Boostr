package com.intuit.honeybadgers.boostr.db.tables;

import javax.annotation.Generated;

/**
 * DbArticle is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class DbArticle {

    private String author;

    private String category;

    private Integer id;

    private String url;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

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

