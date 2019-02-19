package com.metacube.training.model;

import java.util.HashMap;
import java.util.Map;

public class CartModel {

	private Map<ProductModel,Integer> productsInCart; 
	private double totalAmount;
	
	public CartModel(Map<ProductModel, Integer> productsInCart) {
		
		this.productsInCart = productsInCart;
	
	}
	
	public CartModel() {
		
		this.productsInCart=new HashMap<ProductModel, Integer>();
		
	}

	public Map<ProductModel, Integer> getProductsInCart() {
		return productsInCart;
	}

	public void setProductsInCart(Map<ProductModel, Integer> productsInCart) {
		this.productsInCart = productsInCart;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((productsInCart == null) ? 0 : productsInCart.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartModel other = (CartModel) obj;
		if (productsInCart == null) {
			if (other.productsInCart != null)
				return false;
		} else if (!productsInCart.equals(other.productsInCart))
			return false;
		if (Double.doubleToLongBits(totalAmount) != Double
				.doubleToLongBits(other.totalAmount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CartModel [productsInCart=" + productsInCart + ", totalAmount="
				+ totalAmount + "]";
	}
	
	
	
	
}
