package com.metacube.training.model;

import java.util.Map;

public class WareHouse {

	private Map<ProductModel,Integer> availableProducts;

	public Map<ProductModel, Integer> getProductsList() {
		return availableProducts;
	}

	public void setProductsList(Map<ProductModel, Integer> productsList) {
		this.availableProducts = productsList;
	}

	public WareHouse(Map<ProductModel, Integer> productsList) {
	
		this.availableProducts = productsList;
	}

	public WareHouse() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((availableProducts == null) ? 0 : availableProducts.hashCode());
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
		WareHouse other = (WareHouse) obj;
		if (availableProducts == null) {
			if (other.availableProducts != null)
				return false;
		} else if (!availableProducts.equals(other.availableProducts))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WareHouse [productsList=" + availableProducts + "]";
	} 
	
	
	
}
