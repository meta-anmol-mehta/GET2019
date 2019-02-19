package com.metacube.training.model;

public class ProductModel extends BaseEntity {

	
	private String pName;
	private double price;
	private String pCategory;
	public ProductModel(int id,String pName, double price, String pCategory) {
		super(id);
		this.pName = pName;
		this.price = price;
		this.pCategory = pCategory;
	}
	public ProductModel() {
		super();
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getpCategory() {
		return pCategory;
	}
	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((pCategory == null) ? 0 : pCategory.hashCode());
		result = prime * result + ((pName == null) ? 0 : pName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
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
		ProductModel other = (ProductModel) obj;
		if (pCategory == null) {
			if (other.pCategory != null)
				return false;
		} else if (!pCategory.equals(other.pCategory))
			return false;
		if (pName == null) {
			if (other.pName != null)
				return false;
		} else if (!pName.equals(other.pName))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ProductModel [pName=" + pName + ", price=" + price
				+ ", pCategory=" + pCategory + ", getId()=" + getId() + "]";
	}

	
}
