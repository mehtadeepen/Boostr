package com.intuit.honeybadgers.boostr.models;

import java.util.Map;

public class QuestionData {
	/** 
	 * Maps how the response should affect the user's interest in categories
	 */
	Map<Category, Double> responseWeight;
}
