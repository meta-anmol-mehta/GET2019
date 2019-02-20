package com.metacube.training.view;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.metacube.training.dao.InMemoryDao;
import com.metacube.training.enums.Status;
import com.metacube.training.facade.CartFacade;
import com.metacube.training.factory.BaseFactory;

/**
 * 
 * test class to test the functionality of facade layer,Dao layer,base factory
 * 
 * @author admin
 *
 */

public class TestClass {

	InMemoryDao memoryDao = BaseFactory.createInMemoryDao();
	CartFacade cart = BaseFactory.createCartFacade();

	public void initialize() {
		memoryDao.createProduct(1, "Mobile", 15000.0, "Electronics", 3);
		memoryDao.createProduct(2, "Induction", 15000.0, "Electronics", 3);
		memoryDao.createProduct(3, "T-shirt", 15000.0, "Fashion", 3);
		memoryDao.createProduct(4, "Jeans", 15000.0, "Fashion", 3);
		memoryDao.createProduct(5, "Lotion", 15000.0, "Skincare", 3);
	}

	@Test
	public void testPositiveInMemoryAdd() {
		initialize();
		assertEquals(Status.SUCCESS, memoryDao.createProduct(6, "Headphone",
				15000.0, "Electronics", 3));
	}

	@Test
	public void testNegativeInMemoryAdd() {
		initialize();
		assertEquals(Status.DUPLICATE, memoryDao.createProduct(4, "Headphone",
				15000.0, "Electronics", 3));
	}

	@Test
	public void testCornerInMemoryAdd() {
		initialize();
		assertEquals(Status.EMPTY, memoryDao.createProduct(-3, "Headphone",
				15000.0, "Electronics", 3));
	}

	@Test
	public void testPositiveInMemoryUpdate() {
		initialize();
		assertEquals(Status.SUCCESS, memoryDao.updateProduct(4, 8));
	}

	@Test
	public void testNegativeInMemoryUpdate() {
		initialize();
		assertEquals(Status.NOTFOUND, memoryDao.updateProduct(8, 8));
	}

	@Test
	public void testPositiveInMemoryDelete() {
		initialize();
		assertEquals(Status.SUCCESS, memoryDao.deleteProduct(5));
	}

	@Test
	public void testNegativeInMemoryDelete() {
		initialize();
		assertEquals(Status.NOTFOUND, memoryDao.deleteProduct(8));
	}

	@Test
	public void testPostiveAddToCart() {
		initialize();
		assertEquals(Status.SUCCESS, cart.addProductToCart(1, memoryDao));

	}

	@Test
	public void testNegativeAddToCart() {
		initialize();
		assertEquals(Status.FAILURE, cart.addProductToCart(-1, memoryDao));

	}

	@Test
	public void testCornerAddToCart() {
		initialize();
		cart.addProductToCart(1, memoryDao);
		assertEquals(Status.DUPLICATE, cart.addProductToCart(1, memoryDao));

	}

	@Test
	public void testPositiveCartUpdate() {
		initialize();
		cart.addProductToCart(1, memoryDao);
		assertEquals(Status.SUCCESS, cart.updateProductToCart(1, 3));
	}

	@Test
	public void testNegativeCartUpdate() {
		initialize();
		assertEquals(Status.NOTFOUND, memoryDao.updateProduct(8, 8));
	}

	@Test
	public void testPositiveCartDelete() {
		initialize();
		cart.addProductToCart(1, memoryDao);
		assertEquals(Status.SUCCESS, cart.removeProductToCart(1));
	}

	@Test
	public void testNegativeCartDelete() {
		initialize();
		assertEquals(Status.NOTFOUND, memoryDao.deleteProduct(6));
	}
}
