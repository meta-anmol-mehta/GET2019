package com.metacube.training.dao;

import java.util.HashMap;
import java.util.Map;

import com.metacube.training.enums.Status;
import com.metacube.training.factory.BaseFactory;
import com.metacube.training.model.ProductModel;

/**
 * In memory dao class ,here we define the functions of how to access data from db and how to change data in db
 * @author admin
 *
 */

public class InMySQLDao extends ProductDao {

	private Map<ProductModel, Integer> productsAvailable;

	/**
	 * constructor for initializing object of InMemoryDao
	 */
	public InMySQLDao() {

		productsAvailable = new HashMap<ProductModel, Integer>();
	}

	
	@Override
	public Map<ProductModel, Integer> getAll() {

		if (productsAvailable.size() == 0) {
			throw new AssertionError("no products are there");
		}
		return productsAvailable;

	}

	/**
	 * 
	 * check whether the product exist or not
	 * @param id an integer value of product code
	 * @return true if id exist otherwise false
	 */
	
	public boolean isProduct(int id) {

		// implementation to do
		return true;
	}
	
	/**
	 *
	 *createProduct() used toadd product to the memory
	 * @param id,pname,price,pCategory,quantity 
	 * @return value of type status  
	 * 
	 */
	@Override
	public Status createProduct(int id, String pName, double price,
			String pCategory, int quantity) {

		// implementation to do
		return Status.SUCCESS;

	}

	/**
	 *updateProduct() used to update product to the memory
	 * @param id,quantity 
	 * @return value of type status   
	 */
	@Override
	public Status updateProduct(int id, int quantity) {

		// implementation to do
		return Status.SUCCESS;

	}

	/**
	 *deleteProduct() used to delete product to the memory
	 * @param id 
	 * @return value of type status   
	 */
	@Override
	public Status deleteProduct(int id) {

		// implementation to do
		return Status.SUCCESS;

	}

	
	
}
