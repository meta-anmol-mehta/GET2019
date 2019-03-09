package com.metacube.training.question3;

public interface Queue<E> {
	
	public void insert(E element)  ;
	public Object remove() ;
	public boolean isEmpty();
	public boolean isFull() ;
	public Object top();

}
