package com.intuit.honeybadgers.boostr.models;

import java.util.HashMap;
import java.util.Map;

public class User {
	private Map<Category, Double> interests;

	public User() {
		this.interests = new HashMap<Category, Double>();
	}
	
	public Map<Category, Double> getInterests() {
		return interests;
	}
	
	public void incrementCategories(Map<Category, Double> toInc) {
		for (Category key : toInc.keySet()) {
			if(interests.containsKey(key)) {
				interests.put(key, interests.get(key) + toInc.get(key));
			} else {
				interests.put(key, toInc.get(key));
			}
		}
	}
}
