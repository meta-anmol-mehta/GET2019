package com.metacube.training.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

import com.metacube.training.linkedlist.MyLinkedList;

public class MyLinkedListTest {
	
	@Test
	public void positiveRotate(){
		
		MyLinkedList<Integer> list=new MyLinkedList<Integer>();
		MyLinkedList<Integer> resultList=new MyLinkedList<Integer>();
		list.insert(list, 2);
		list.insert(list, 3);
		list.insert(list, 4);
		list.insert(list, 5);
		list.insert(list, 6);
		list.insert(list, 7);
		
		resultList.insert(resultList, 2);
		resultList.insert(resultList, 5);
		resultList.insert(resultList, 6);
		resultList.insert(resultList, 3);
		resultList.insert(resultList, 4);
		resultList.insert(resultList, 7);
		
		assertEquals(resultList.toString(),list.rotate(list, 2, 5, 2).toString());
	}
	
	@Test(expected=AssertionError.class)
	public void negativeRotate(){
		
		MyLinkedList<Integer> list=new MyLinkedList<Integer>();
		MyLinkedList<Integer> resultList=new MyLinkedList<Integer>();
		list.insert(list, 2);
		list.insert(list, 3);
		list.insert(list, 4);
		list.insert(list, 5);
		list.insert(list, 6);
		list.insert(list, 7);
		
		resultList.insert(resultList, 2);
		resultList.insert(resultList, 5);
		resultList.insert(resultList, 6);
		resultList.insert(resultList, 3);
		resultList.insert(resultList, 4);
		resultList.insert(resultList, 7);
		
		assertEquals(resultList.toString(),list.rotate(list, 6, 5, 2).toString());
	}

	@Test(expected=NullPointerException.class)
	public void nullListRotate(){
		
		MyLinkedList<Integer> list=new MyLinkedList<Integer>();
		MyLinkedList<Integer> resultList=new MyLinkedList<Integer>();
	
		
		assertEquals(resultList.toString(),list.rotate(list, 2, 5, 2).toString());
	}
	@Test
	public void postiveDetectLoop(){
		
		MyLinkedList<Integer> list=new MyLinkedList<Integer>();
		list.insert(list, 2);
		list.insert(list, 3);
		list.insert(list, 4);
		list.insert(list, 5);
		list.insert(list, 6);
		list.insert(list, 7);
		
		list.getHead().getNext().getNext().getNext().getNext().setNext(list.getHead().getNext().getNext());
		
		assertEquals(true,list.detectLoop(list));
	}
	
	@Test
	public void negativeDetectLoop(){
		
		MyLinkedList<Integer> list=new MyLinkedList<Integer>();
		list.insert(list, 2);
		list.insert(list, 3);
		list.insert(list, 4);
		list.insert(list, 5);
		list.insert(list, 6);
		list.insert(list, 7);
		
		
		assertEquals(false,list.detectLoop(list));
	}
	
	@Test(expected=NullPointerException.class)
	public void nullDetectLoop(){
		
		MyLinkedList<Integer> list=new MyLinkedList<Integer>();

		
		
		assertEquals(false,list.detectLoop(list));
	}
	
}
