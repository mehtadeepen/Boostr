package com.intuit.honeybadgers.boostr.server;

import com.intuit.honeybadgers.boostr.models.Category;

import java.util.Map;

/**
 * @author ddubois
 */
public class AnswerRequest {
    Map<Category, Float> data;

    AnswerRequest( Map<Category, Float> newData ) {
        data = newData;
    }

    public Map<Category, Float> getData() {
        return data;
    }
}
