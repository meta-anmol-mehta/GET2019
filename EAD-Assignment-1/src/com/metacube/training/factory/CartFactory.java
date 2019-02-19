package com.metacube.training.factory;

import java.util.Map;

import com.metacube.training.model.CartModel;
import com.metacube.training.model.ProductModel;

public class CartFactory {

	
	public static CartModel createCart(Map<ProductModel,Integer> productsInCart){
		
		return new CartModel(productsInCart);
		
	}
	
}
