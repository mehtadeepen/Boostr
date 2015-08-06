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
    String uuid;

    public AnswerRequest() {
        data = new HashMap<>();
    }

    AnswerRequest( Map<Category, Float> newData, String newUuid ) {
        data = newData;
        uuid = newUuid;
    }

    public Map<Category, Float> getData() {
        return data;
    }

    public String getUuid() {
        return uuid;
    }
}
