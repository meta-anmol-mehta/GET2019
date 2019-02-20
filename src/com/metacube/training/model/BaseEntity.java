package com.metacube.training.model;


	/**
	 * baseEntityu model
	 * @author admin
	 *
	 */
public class BaseEntity {

	private int id;

	public BaseEntity(int id) {
		this.id = id;
	}

	public BaseEntity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
