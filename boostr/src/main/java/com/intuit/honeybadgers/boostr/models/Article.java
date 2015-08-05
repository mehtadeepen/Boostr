package com.intuit.honeybadgers.boostr.models;

import java.net.URI;

public class Article {
	/** Link to the article */
	URI location;
	/** Author name and basic credentials */
	String author;
	/** What category this falls under */
	Category category;

	public Article( URI newLocation, String newAuthor, Category newCategory ) {
		location = newLocation;
		author = newAuthor;
		category = newCategory;
	}

	public Category getCategory() {
		return  category;
	}

	public String getAuthor() {
		return author;
	}

	public URI getLocation() {
		return location;
	}
}
