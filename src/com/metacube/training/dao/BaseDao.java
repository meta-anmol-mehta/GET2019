package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.enums.Status;
import com.metacube.training.model.BaseEntity;

public interface BaseDao<T> {

	/**
	 * Method to return the list of T objects
	 * @return list
	 */
	public List<T> getList();

	/**
	 * Method to insert new data into database
	 * 
	 * @param advertisement
	 * @return status
	 */
	public Status insert(T entity);

	/**
	 * Method to delete the data
	 * 
	 * @param id of the data
	 * @return status
	 */
	public Status delete(int id);

	/**
	 * Method to update data 
	 * 
	 * @param    generic data
	 * @param id of the advertisement
	 */
	public Status update(T entity);

}
