package com.metacube.training.question4;


public class StudentNode {

	private String name;
	private String[] data;
	private StudentNode next;

	public StudentNode(String name, String[] data) {
		this.name = name;
		this.data = data;
		this.next = null;
	}

	public StudentNode getNext() {
		return next;
	}

	public void setNext(StudentNode next) {
		this.next = next;
	}

	public String[] getData() {
		return this.data;
	}

	public String getName() {
		return this.name;
	}

}