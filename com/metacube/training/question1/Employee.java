package com.metacube.training.question1;


/**
 * This class is used to store employee's details
 * @author admin
 *
 */

public class Employee {

	private int id;
	private String name;
	private String address;
	public Employee(int id, String name, String address) {
		
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public Employee() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address
				+ "]";
	}
	
	
	
}
