package com.metacube.training.dao;


import com.metacube.training.enums.Status;
import com.metacube.training.model.ProductModel;

public abstract class ProductDao implements BaseDao<ProductModel> {

	public Status createProduct(int id, String pName, double price,String pCategory,int quantity){
		return Status.SUCCESS;
	}

	public Status updateProduct(int id, int quantity) {
		return Status.SUCCESS;
	}
	public Status deleteProduct(int id) {
		return Status.SUCCESS;
		}
}
