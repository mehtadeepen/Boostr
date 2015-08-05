package com.intuit.honeybadgers.boostr.models;

import java.net.URI;

public class Article {
	/** Link to the article */
	URI location;
	/** Author name and basic credentials */
	String author;
	/** What category this falls under */
	Category category;
}
