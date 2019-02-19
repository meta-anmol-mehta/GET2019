package com.metacube.training.factory;



import com.metacube.training.model.CartModel;
import com.metacube.training.model.ProductModel;
import com.metacube.training.model.UserModel;

public class BaseFactory {

	public static CartModel createCart() {

		return new CartModel();

	}

	public static ProductModel createProduct(int pId, String pName,
			double price, String pCategory) {

		return new ProductModel(pId, pName, price, pCategory);

	}

	public static UserModel createUser(int id, String name, String mobileNo,
			String emailAddress) {
		return new UserModel(id, name, mobileNo, emailAddress);
	}

}
