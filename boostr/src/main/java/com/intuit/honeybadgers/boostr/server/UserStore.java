package com.intuit.honeybadgers.boostr.server;

import java.util.Map;

import com.intuit.honeybadgers.boostr.models.User;

public class UserStore {
	/** map from UUID to user object */
	private Map<String, User> users;
	public User getUser(String uuid) {
		return users.get(uuid);
	}
	
}
