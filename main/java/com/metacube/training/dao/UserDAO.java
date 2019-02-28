package com.metacube.training.dao;

import java.util.List;


import com.metacube.training.model.User;
import com.metacube.training.model.UserCredential;

 /**
 * In userdao class ,here we define the functions of how to access data from db and how to change data in db
 *
 * @author admin
 *
 */

public interface UserDAO {

	/**
	 * to add user to database
	 * @param user
	 * @return
	 */
	public boolean add(User user);

	/**
	 * get user by its id
	 * @param id
	 * @return
	 */
	public User get(Integer id);

	/**
	 * update user details
	 * @param user
	 * @return
	 */
	public boolean update(User user);

	/**
	 * get all users in the list
	 * @return
	 */
	public List<User> getAll();

	/**
	 * delete user by id
	 * @param id
	 * @return
	 */
	public boolean delete(Integer id);
	
	/**
	 * search user by name and attribute
	 * @param attribute
	 * @param value
	 * @return
	 */
	public List<User> getByAttribute(String attribute, String value);
	
	/**
	 * get user crentials for authentication
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean getUsersCredentials(String username,String password);
	
}
