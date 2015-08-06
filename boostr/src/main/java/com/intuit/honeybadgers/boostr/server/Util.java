package com.intuit.honeybadgers.boostr.server;

import com.intuit.honeybadgers.boostr.models.Category;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ajeddeloh on 8/5/15.
 */
public class Util {
    public static void postSlider (int sliderValue, String uuid) {
        float normalized = ((float)(sliderValue - 50))/50f;
        Map<Category, Float> ret = new HashMap<Category,Float>();
        ret.put(Category.CreditCards, -normalized);
        ret.put(Category.Savings, -normalized);
        ret.put(Category.Interest, normalized);
        ret.put(Category.Retirement, normalized);
        ret.put(Category.Loans, -normalized);
        System.out.println( "Values in Util.postSlider: " +ret +" Normalized: " +normalized );
        Client tmp = Client.create();
        WebResource res = tmp.resource( "http://localhost:8080/boostr/server/answer" );
        ClientResponse response = res.accept( MediaType.APPLICATION_JSON ).type( MediaType.APPLICATION_JSON ).post( ClientResponse.class, new AnswerRequest( ret, uuid ) );
    }
}
