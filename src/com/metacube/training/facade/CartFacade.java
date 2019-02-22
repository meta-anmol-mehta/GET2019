package com.metacube.training.facade;

import java.util.HashMap;
import java.util.Map;

import com.metacube.training.dao.InMemoryDao;
import com.metacube.training.dao.ProductDao;
import com.metacube.training.enums.DBType;
import com.metacube.training.enums.Status;
import com.metacube.training.factory.BaseFactory;
import com.metacube.training.model.CartModel;
import com.metacube.training.model.ProductModel;

/**
 * 
 * @author admin
 * CartFacade class is used to provide the functionality of cartModel
 * like addProducttoCart()
 * like deletefromcart()
 * like updatefromcart()
 *
 */

public class CartFacade {

	private CartModel model;
	private Map<ProductModel, Integer> productsAvailable;
	private Map<ProductModel, Integer> productsInCart;
	private ProductDao dao;

	public CartFacade(DBType dbType) {

		this.model = BaseFactory.createCart();
		productsInCart = new HashMap<ProductModel, Integer>();
		productsAvailable = new HashMap<ProductModel, Integer>();
		if(dbType.equals(DBType.INMEMORY)){
			dao=BaseFactory.createInMemoryDao();
		}
		else{
			dao=BaseFactory.createInSQLDao();	
		}
	}

	/**
	 * 
	 * like product already exist in cart or not
	 * @param id
	 * @return true if id exist otherwise false
	 */
	public boolean isProduct(int id) {

		for (Map.Entry<ProductModel, Integer> entry : productsInCart.entrySet()) {
			if (entry.getKey().getId() == id) {
				return true;
			}
		}
		return false;

	}

	/**
	 * 
	 * used add product in cart
	 * @param id
	 * @param memoryDao
	 * @return enum Status 
	 */
	public Status addProductToCart(int id,int quantity) {

		if (id < 0) {
			return Status.FAILURE;
		}
		productsAvailable = dao.getAll();

		if (isProduct(id)) {
			return Status.DUPLICATE;
		}
		for (Map.Entry<ProductModel, Integer> entry : productsAvailable
				.entrySet()) {
			if (entry.getKey().getId() == id) {
				entry.setValue(entry.getValue() - 1);
				productsInCart.put(entry.getKey(), entry.getValue());
				model.setProductsInCart(productsInCart);
				return Status.SUCCESS;
			}
		}

		return Status.NOTFOUND;

	}

	/**
	 * used to remove from cart
	 * @param id
	 * @return enum status
	 */
	public Status removeProductToCart(int id) {

		if (id < 0) {
			return Status.FAILURE;
		}

		for (Map.Entry<ProductModel, Integer> entry : productsInCart.entrySet()) {
			if (entry.getKey().getId() == id) {
				productsInCart.remove(entry.getKey());
				model.setProductsInCart(productsInCart);
				return Status.SUCCESS;
			}
		}

		return Status.NOTFOUND;

	}

	/**
	 *  used to update the cart
	 * @param id
	 * @param quantity
	 * @return enum status
	 */
	public Status updateProductToCart(int id, int quantity) {

		if (id < 0) {
			return Status.FAILURE;
		}

		for (Map.Entry<ProductModel, Integer> entry : productsInCart.entrySet()) {
			if (entry.getKey().getId() == id) {
				entry.setValue(quantity);
				model.setProductsInCart(productsInCart);
				return Status.SUCCESS;
			}
		}

		return Status.NOTFOUND;

	}

	/**
	 * get all products in cart
	 * @return hashmap of type product,integer
	 */
	public Map<ProductModel, Integer> getCartProducts() {

		return model.getProductsInCart();

	}

	public ProductDao getDao() {
		return dao;
	}

	public void setDao(ProductDao dao) {
		this.dao = dao;
	}

	
	
}
