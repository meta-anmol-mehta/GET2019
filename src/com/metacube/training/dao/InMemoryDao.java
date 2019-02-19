package com.metacube.training.dao;

import java.util.HashMap;
import java.util.Map;

import com.metacube.training.enums.Status;
import com.metacube.training.model.ProductModel;

public class InMemoryDao extends ProductDao{

	private Map<ProductModel,Integer> productsAvailable; 
	
	public InMemoryDao() {
		
		productsAvailable=new HashMap<ProductModel, Integer>();
	}

	@Override
	public Map<ProductModel,Integer> getAll() {
		
		if(productsAvailable.size()==0){
			throw new AssertionError("no products are there");
		}
		return productsAvailable;
		
		
	}

	public boolean isProduct(int id){
		
		for(Map.Entry<ProductModel, Integer> entry: productsAvailable.entrySet()) {
			   if(entry.getKey().getId()==id){
			   return true;
			   }
			}
		return false;
		
	}
	
	public Status createProduct(int id, String pName, double price,String pCategory,int quantity) {

		if(id>0||pName.isEmpty()||price>0.0||pCategory.isEmpty()||quantity>0){
			return Status.EMPTY;
		}
		if(isProduct(id)){
			return Status.DUPLICATE;
		}
		ProductModel product=new ProductModel(id,pName,price,pCategory);
		productsAvailable.put(product, quantity);
		return Status.SUCCESS;
		
	}

	public Status updateProduct(int id, int quantity) {

		if(productsAvailable.size()==0){
			return Status.EMPTY;
		}
		
		for(Map.Entry<ProductModel, Integer> entry: productsAvailable.entrySet()) {
		   if(entry.getKey().getId()==id){
			entry.setValue(quantity);
		   return Status.SUCCESS;
		   }
		}
		return Status.NOTFOUND;
		
	}

	public Status deleteProduct(int id) {

		if(productsAvailable.size()==0){
			return Status.EMPTY;
		}
		
		for(Map.Entry<ProductModel, Integer> entry: productsAvailable.entrySet()) {
		   if(entry.getKey().getId()==id){
			productsAvailable.remove(entry.getKey());
		   return Status.SUCCESS;
		   }
		}
		return Status.NOTFOUND;
		
	}

	
	
	
}
