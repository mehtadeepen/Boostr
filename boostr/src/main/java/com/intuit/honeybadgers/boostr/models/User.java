package com.intuit.honeybadgers.boostr.models;

import java.util.HashMap;
import java.util.Map;

public class User {
	private String uuid;
	private Map<Category, Float> interests;

	public User() {
		this.interests = new HashMap<Category, Float>();
	}

	public User( String uuid, Map<Category, Float> userData ) {
		this.uuid = uuid;
		interests = userData;
	}

	public Map<Category, Float> getInterests() {
		return interests;
	}
	
	public void incrementCategories(Map<Category, Float> toInc) {
		for (Category key : toInc.keySet()) {
			if(interests.containsKey(key)) {
				interests.put(key, interests.get(key) + toInc.get(key));
			} else {
				interests.put(key, toInc.get(key));
			}
		}
	}
}
