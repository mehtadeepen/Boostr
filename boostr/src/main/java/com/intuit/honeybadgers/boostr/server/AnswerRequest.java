package com.intuit.honeybadgers.boostr.server;

import com.intuit.honeybadgers.boostr.models.Category;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ddubois
 */
@XmlRootElement
public class AnswerRequest {
    Map<Category, Float> data;

    public AnswerRequest() {
        data = new HashMap<>();
    }

    AnswerRequest( Map<Category, Float> newData ) {
        data = newData;
    }

    public Map<Category, Float> getData() {
        return data;
    }
}
