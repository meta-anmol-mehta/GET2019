package com.metacube.training.linkedlist;

/**
 * 
 * @author admin
 *
 * @param <T> create anode of any type
 */

public class Node<T> {
	
	private  T data;
	private Node<T> next;

	public Node(T data) {
		this.data = data;
	}
	
	public Node(){
		
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
	
	

}
