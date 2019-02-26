package com.metacube.training.model;

/**
 * Class containing the advertisement entities
 */

public class Advertisement extends BaseEntity {

	private String title;
	private String description;
	private int categoryID;

	public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public Advertisement() {
		super();
	}
	
	public Advertisement(int id,String title, String description,int categoryID) {
		super(id);
		this.title = title;
		this.description = description;
		this.categoryID=categoryID;
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
