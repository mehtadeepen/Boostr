package com.intuit.honeybadgers.boostr.server;

import com.intuit.honeybadgers.boostr.models.Category;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ajeddeloh on 8/5/15.
 */
public class Util {
    public static void postSlider (int sliderValue, String uuid) {
        float normalized = (sliderValue - 50)/50;
        Map<Category, Float> ret = new HashMap<Category,Float>();
        ret.put(Category.CreditCards, -normalized);
        ret.put(Category.Savings, -normalized);
        ret.put(Category.Interest, normalized);
        ret.put(Category.Retirement, normalized);
        ret.put(Category.Loans, -normalized);
        Client tmp = Client.create();
        WebResource res = tmp.resource("/boostr/server/answer?uuid=" + uuid);
        res.post(ret);
    }
}
