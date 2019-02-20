package com.metacube.training.controller;

import java.util.Map;

import com.metacube.training.dao.InMemoryDao;
import com.metacube.training.dao.ProductDao;
import com.metacube.training.enums.DBType;
import com.metacube.training.enums.Status;
import com.metacube.training.factory.BaseFactory;
import com.metacube.training.model.ProductModel;


/**
 *  base controller is used control the flow in the architecture
 * @author admin
 *
 */

public class ViewController {
	
		private DBType dbType;
		private ProductDao productDao;
		
		public ViewController(DBType dbType){
			
			if(dbType.equals(DBType.INMEMORY)){
				productDao=BaseFactory.createInMemoryDao();
			}
			else{
				productDao=BaseFactory.createInSQLDao();
			}
		}
	
		public Map<ProductModel, Integer> getAll() {

			
			return productDao.getAll();
			

		}
		
		/**
		 *
		 *createProduct() 
		 * @param id,pname,price,pCategory,quantity 
		 * @return value of type status  
		 * 
		 */
		
		public Status createProduct(int id, String pName, double price,
				String pCategory, int quantity) {

			return productDao.createProduct(id, pName, price, pCategory, quantity);
		

		}

		/**
		 *updateProduct() 
		 * @param id,quantity 
		 * @return value of type status   
		 */
		
		public Status updateProduct(int id, int quantity) {

			return productDao.updateProduct(id, quantity);

		}

		/**
		 *deleteProduct()
		 * @param id 
		 * @return value of type status   
		 */
		
		public Status deleteProduct(int id) {

			return productDao.deleteProduct(id);
			

		}

}
