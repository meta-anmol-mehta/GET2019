package com.metacube.training.dao;

import java.util.Map;

import com.metacube.training.enums.Status;
import com.metacube.training.model.ProductModel;

/**
 * 
 * @author admin
 * ProductDao is used to create function on products
 *
 */

public class ProductDao  {

	/**
	 * used to create product 
	 * @param id
	 * @param pName
	 * @param price
	 * @param pCategory
	 * @param quantity
	 * @return status
	 */
	public Status createProduct(int id, String pName, double price,
			String pCategory, int quantity){
		return Status.SUCCESS;
	}

	/**
	 * used to update product
	 * @param id
	 * @param quantity
	 * @return status
	 */
	public Status updateProduct(int id, int quantity){
		return Status.SUCCESS;
	}

	/**
	 * used to delete product
	 * @param id
	 * @return status
	 */
	public Status deleteProduct(int id){
		return Status.SUCCESS;
	}
	
	/**
	 * used to get all the products
	 * 
	 * @return map that contains product with quantity  
	 */
	public Map<ProductModel, Integer> getAll(){
	
		return null;
		
	}
}
