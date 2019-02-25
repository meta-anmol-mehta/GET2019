package com.metacube.training.model;

/**
 * Class containing the advertisement entities
 */

public class Advertisement extends BaseEntity {

	private String title;
	private String description;

	public Advertisement() {
		super();
	}
	
	public Advertisement(int id,String title, String description) {
		super(id);
		this.title = title;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
