package com.metacube.training.facade;

import java.util.List;

import com.metacube.training.dao.CategoryDao;
import com.metacube.training.enums.Status;
import com.metacube.training.factory.BaseFactory;
import com.metacube.training.model.Category;

public class CategoryFacade {

	CategoryDao categoryDao = BaseFactory.createCategoryDao();

	/**
	 * Function to return status for insertion
	 * 
	 * @param name name of category to be inserted
	 * @return status status of operation
	 */
	public Status insertCategory(Category cat) {
		List<Category> categoryList = categoryDao.getList();

		for (Category category : categoryList) {
			if (category.getName().equals(cat.getName())) {
				return Status.DUPLICATE;
			}
		}
		return ((CategoryDao) categoryDao).insert(cat);
	}

	/**
	 * Function to return the list of category
	 * 
	 * @return list of all categories
	 */
	public List<Category> getAll() {
		return categoryDao.getList();
	}

	/**
	 * Function to return the status for updated
	 * 
	 * @param category category object
	 * 
	 * @return status status of operation
	 */
	public Status updateCategory(Category category) {
		return ((CategoryDao) categoryDao).update(category);
	}

	/**
	 * Function to return the status for deletion
	 * 
	 * @param category category object
	 * @return status status of operation
	 */
	public Status deleteCategory(int id) {
		return ((CategoryDao) categoryDao).delete(id);
	}

}
