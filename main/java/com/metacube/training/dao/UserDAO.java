package com.metacube.training.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.metacube.training.model.User;

public interface UserDAO {

	public boolean add(User user);

	public User get(Integer id);

	public boolean update(User user);

	public List<User> getAll();

	public boolean delete(Integer id);
	
	 public List<User> getByAttribute(String attribute, String value);
}
