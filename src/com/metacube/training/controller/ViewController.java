package com.metacube.training.controller;

import java.util.Map;

import com.metacube.training.dao.InMemoryDao;
import com.metacube.training.dao.ProductDao;
import com.metacube.training.enums.DBType;
import com.metacube.training.enums.Status;
import com.metacube.training.facade.CartFacade;
import com.metacube.training.factory.BaseFactory;
import com.metacube.training.model.ProductModel;


/**
 *  base controller is used control the flow in the architecture
 * @author admin
 *
 */

public class ViewController {
	
		private CartFacade cartFacade;
		
		public ViewController(DBType dbType){
			
			cartFacade=BaseFactory.createCartFacade(dbType);
		}
	
		public Map<ProductModel, Integer> getAll() {

			
			return cartFacade.getCartProducts();
			

		}
		
		/**
		 *
		 *createProduct() 
		 * @param id,pname,price,pCategory,quantity 
		 * @return value of type status  
		 * 
		 */
		
		public Status createProduct(int id,int quantity) {

			return cartFacade.addProductToCart(id, quantity);
		

		}

		/**
		 *updateProduct() 
		 * @param id,quantity 
		 * @return value of type status   
		 */
		
		public Status updateProduct(int id, int quantity) {

			return cartFacade.updateProductToCart(id, quantity);

		}

		/**
		 *deleteProduct()
		 * @param id 
		 * @return value of type status   
		 */
		
		public Status deleteProduct(int id) {

			return cartFacade.removeProductToCart(id);
			

		}

}
