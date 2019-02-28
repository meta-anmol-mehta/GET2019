package com.metacube.training.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metacube.training.model.User;
@Service
public interface UserService {
	
	public boolean add(User user);
	
	public User get(Integer id);
	
	public boolean update(User user);
	
	public List<User> getAll();
	
	public boolean delete(Integer id);
	
	public List<User> getByAttribute(String attribute , String Value);
	
}
