package com.metacube.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.interfaces.UserDAO;
import com.metacube.training.interfaces.UserService;
import com.metacube.training.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public boolean add(User user) {

		return userDAO.add(user);

	}

	@Override
	public User get(Integer id) {

		return userDAO.get(id);

	}

	@Override
	public boolean update(User user) {
		return userDAO.update(user);

	}

	@Override
	public List<User> getAll() {

		return userDAO.getAll();

	}

	@Override
	public boolean delete(Integer id) {
		return userDAO.delete(id);
	}

	@Override
	public List<User> getByAttribute(String attribute, String Value) {
		return userDAO.getByAttribute(attribute, Value);

	}

	@Override
	public boolean getUsers(String username, String password) {
		// TODO Auto-generated method stub
		return userDAO.getUsersCredentials(username, password);

	}
}
