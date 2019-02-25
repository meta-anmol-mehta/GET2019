package com.metacube.training.model;


/**
 * Base class containing id 
 */
public class BaseEntity {
	private int id;

	public BaseEntity() {
		super();
	}
	
	public BaseEntity(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
