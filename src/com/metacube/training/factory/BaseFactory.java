package com.metacube.training.factory;

import com.metacube.training.dao.InMemoryDao;
import com.metacube.training.dao.InMySQLDao;
import com.metacube.training.enums.DBType;
import com.metacube.training.facade.CartFacade;
import com.metacube.training.model.CartModel;
import com.metacube.training.model.ProductModel;
import com.metacube.training.model.UserModel;

/**
 *  used to create object in entire architecture
 * @author admin
 *
 */
public class BaseFactory {

	/**
	 * used to create object of cartmodel
	 * @return cartmodel object
	 */
	public static CartModel createCart() {

		return new CartModel();

	}

	/**
	 * used to create object of productmodel
	 * @return productModel object
	 */
	public static ProductModel createProduct(int pId, String pName,
			double price, String pCategory) {

		return new ProductModel(pId, pName, price, pCategory);

	}

	/**
	 * used to create object of createuser
	 * @return createuser object
	 */
	public static UserModel createUser(int id, String name, String mobileNo,
			String emailAddress) {
		return new UserModel(id, name, mobileNo, emailAddress);
	}

	/**
	 * used to create object of InMemoryDao
	 * @return InMemoryDao object
	 */
	public static InMemoryDao createInMemoryDao() {
		return new InMemoryDao();
	}

	/**
	 * used to create object of InSQLDao
	 * @return InSQLDao object
	 */
	public static InMySQLDao createInSQLDao() {
		return new InMySQLDao();
	}
	
	
	/**
	 * used to create object of CartFacade
	 * @return CartFacade object
	 */
	public static CartFacade createCartFacade(DBType dbType) {
		return new CartFacade(dbType);
	}
}
