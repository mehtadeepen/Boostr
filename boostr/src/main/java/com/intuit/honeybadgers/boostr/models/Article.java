package com.intuit.honeybadgers.boostr.models;

import java.net.URI;

public class Article {
	/** Link to the article */
	URI location;
	/** Author name and basic credentials */
	String author;
	/** What category this falls under */
	Category category;
	String title;

	public Article( URI newLocation, String newAuthor, Category newCategory, String newTitle ) {
		location = newLocation;
		author = newAuthor;
		category = newCategory;
		title = newTitle;
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

	public String getTitle() {
		return title;
	}
}
