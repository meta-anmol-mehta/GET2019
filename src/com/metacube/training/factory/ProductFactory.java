package com.metacube.training.factory;

import com.metacube.training.model.ProductModel;

public class ProductFactory {

	public static ProductModel createProduct(int pId,String pName,double price,String pCategory){
		
		return new ProductModel(pId, pName, price, pCategory);
		
	}
	
}
