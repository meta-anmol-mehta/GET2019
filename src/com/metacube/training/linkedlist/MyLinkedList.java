package com.metacube.training.linkedlist;

/**
 * 
 * @author admin
 *
 * @param <T> genric linked list class to accept any type of data
 * 
 */

public class MyLinkedList<T> {

	private Node<T> head;

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public MyLinkedList() {
		
	}

	/**
	 * 
	 * @param list in which data has to be inserted
	 * @param data what value to be insert
	 * @return list of type linkedList
	 */
	public boolean insert(MyLinkedList<T> list ,T data){
		
		if(data!=null){
		Node newNode=new Node<T>(data);
		newNode.setNext(null);
		
		if(list.getHead()==null){
			list.setHead(newNode);	
		}
		else{
			Node nextNode=list.getHead();
			while(nextNode.getNext()!=null){
				nextNode=nextNode.getNext();
			}
			nextNode.setNext(newNode);
		}
		return true;
		}
		return false;
		
	}
	
	
	/**
	 * 
	 * @param list that is to be rotate
 	 * @param left index from where rotation has to start
	 * @param right index from where rotation has to end
	 * @param noOfRotations how much rotation has to be perform
	 * @return rotated list
	 */
	public MyLinkedList<T> rotate(MyLinkedList<T> list,int left,int right,int noOfRotations){
		
		Node nextNode;
		int counter;
		T temp;
		if(left>right){
			 new AssertionError("Invalid index");
		}
		else if(list.getHead()==null){
			 new NullPointerException("empty list");
		}
		for(int i=0;i<noOfRotations;++i){
			
			 nextNode=list.getHead();
			 counter=1;
	
			while(nextNode.getNext()!=null){
	
				if(counter>=left&&counter<right){
				
					temp=(T)nextNode.getData();
					nextNode.setData(nextNode.getNext().getData());
					nextNode.getNext().setData(temp);
					
				}
				nextNode=nextNode.getNext();
				counter++;
		
				
				
			}
		
		}
		
		return list;
		
	}
	/**
	 * 
	 * @param list to detect loop in the list
	 * @return true if loop occur else false
	 */
	public boolean detectLoop(MyLinkedList<T> list){
		
		if(list.getHead()==null){
			 new NullPointerException("empty list");
		}
		
		Node firstNode=list.getHead(),nextNode=list.getHead();
		
		while(nextNode.getNext().getNext()!=null)
		{
			firstNode=firstNode.getNext();
			nextNode=nextNode.getNext().getNext();
			if(firstNode==nextNode){
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public String toString() {
		return "MyLinkedList [head=" + head + "]";
	}
	
	
}
