package com.metacube.training.question1;

public class Node <T>{

	String key;
	T value;
	
	public Node(String key, T value) {
		
		this.key = key;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	
}
