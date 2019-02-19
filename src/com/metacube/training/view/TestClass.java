package com.metacube.training.view;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.metacube.training.dao.InMemoryDao;
import com.metacube.training.enums.Status;

public class TestClass {

	InMemoryDao memoryDao=new InMemoryDao();
	
	public void initialize(){
		memoryDao.createProduct(1, "Mobile", 15000.0, "Electronics", 3);
		memoryDao.createProduct(2, "Induction", 15000.0, "Electronics", 3);
		memoryDao.createProduct(3, "T-shirt", 15000.0, "Fashion", 3);
		memoryDao.createProduct(4, "Jeans", 15000.0, "Fashion", 3);
		memoryDao.createProduct(5, "Lotion", 15000.0, "Skincare", 3);
	}
	@Test
	public void testPositiveInMemoryAdd(){
		
		assertEquals(Status.SUCCESS,memoryDao.createProduct(6, "Headphone", 15000.0, "Electronics", 3));
	}
	@Test
	public void testNegativeInMemoryAdd(){
		
		assertEquals(Status.DUPLICATE,memoryDao.createProduct(4, "Headphone", 15000.0, "Electronics", 3));
	}
	@Test
	public void testCornerInMemoryAdd(){
		
		assertEquals(Status.EMPTY,memoryDao.createProduct(-3, "Headphone", 15000.0, "Electronics", 3));
	}
	@Test
	public void testPositiveInMemoryUpdate(){
		
		assertEquals(Status.SUCCESS,memoryDao.updateProduct(4, 8));
	}
	@Test
	public void testNegativeInMemoryUpdate(){
		
		assertEquals(Status.NOTFOUND,memoryDao.updateProduct(8, 8));
	}
}
