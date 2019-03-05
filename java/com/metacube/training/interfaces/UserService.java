package com.metacube.training.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metacube.training.model.User;
import com.metacube.training.model.UserCredential;

/**
 * 
 * @author admin interface to provide functionality at uservice layer
 */

@Service
public interface UserService {

	/**
	 * add user in db
	 * 
	 * @param user
	 * @return
	 */
	public boolean add(User user);

	/**
	 * get user by id
	 * 
	 * @param id
	 * @return
	 */
	public User get(Integer id);

	/**
	 * update user
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(User user);

	/**
	 * get all user
	 * 
	 * @return
	 */
	public List<User> getAll();

	/**
	 * delete all user
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(Integer id);

	/**
	 * search user by attribute
	 * 
	 * @param attribute
	 * @param Value
	 * @return
	 */
	public List<User> getByAttribute(String attribute, String Value);

	/**
	 * get user credentials
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean getUsers(String username, String password);
}
