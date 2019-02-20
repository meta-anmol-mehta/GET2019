package com.metacube.training.dao;

import java.util.HashMap;
import java.util.Map;

import com.metacube.training.enums.Status;
import com.metacube.training.factory.BaseFactory;
import com.metacube.training.model.ProductModel;
/**
 * In memory dao class ,here we define the functions of how to access data from memory and how to change data in memory
 * @author admin
 *
 */
public class InMemoryDao extends ProductDao {

	private Map<ProductModel, Integer> productsAvailable;

	/**
	 * constructor for initializing object of InMemoryDao
	 */
	public InMemoryDao() {

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

		for (Map.Entry<ProductModel, Integer> entry : productsAvailable
				.entrySet()) {
			if (entry.getKey().getId() == id) {
				return true;
			}
		}
		return false;

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

		if (id < 0 || pName.isEmpty() || price < 0.0 || pCategory.isEmpty()
				|| quantity < 0) {
			return Status.EMPTY;
		}
		if (isProduct(id)) {
			return Status.DUPLICATE;
		}
		ProductModel product = BaseFactory.createProduct(id, pName, price,
				pCategory);
		productsAvailable.put(product, quantity);
		return Status.SUCCESS;

	}

	/**
	 *updateProduct() used to update product to the memory
	 * @param id,quantity 
	 * @return value of type status   
	 */
	@Override
	public Status updateProduct(int id, int quantity) {

		if (productsAvailable.size() == 0) {
			return Status.EMPTY;
		}

		for (Map.Entry<ProductModel, Integer> entry : productsAvailable
				.entrySet()) {
			if (entry.getKey().getId() == id) {
				entry.setValue(quantity);
				return Status.SUCCESS;
			}
		}
		return Status.NOTFOUND;

	}

	/**
	 *deleteProduct() used to delete product to the memory
	 * @param id 
	 * @return value of type status   
	 */
	@Override
	public Status deleteProduct(int id) {

		if (productsAvailable.size() == 0) {
			return Status.EMPTY;
		}

		for (Map.Entry<ProductModel, Integer> entry : productsAvailable
				.entrySet()) {
			if (entry.getKey().getId() == id) {
				productsAvailable.remove(entry.getKey());
				return Status.SUCCESS;
			}
		}
		return Status.NOTFOUND;

	}

}
