package com.metacube.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.UserDAO;
import com.metacube.training.model.User;
import com.metacube.training.model.UserCredential;
import com.metacube.training.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public boolean add(User user) {
		try{
		return userDAO.add(user);
		}
		catch(NullPointerException e){
		MyLogFile.writeToFile("Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
		}
	}

	@Override
	public User get(Integer id) {
		try{
		return userDAO.get(id);
		}
		catch(NullPointerException e){
		MyLogFile.writeToFile("Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
		}
	}

	@Override
	public boolean update(User user) {
		try{
		return userDAO.update(user);
		}
		catch(NullPointerException e){
		MyLogFile.writeToFile("Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
		}
	}

	@Override
	public List<User> getAll() {
		try{
		return userDAO.getAll();
		}
		catch(NullPointerException e){
		MyLogFile.writeToFile("Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
		}
	}

	@Override
	public boolean delete(Integer id) {
		try{
		return userDAO.delete(id);
		}
		catch(NullPointerException e){
		MyLogFile.writeToFile("Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
		}
	}
	
	@Override
	public List<User> getByAttribute(String attribute , String Value){
	        try{
		return userDAO.getByAttribute(attribute,Value);
		}
		catch(NullPointerException e){
		MyLogFile.writeToFile("Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
		}
	}

	@Override
	public boolean getUsers(String username,String password) {
		// TODO Auto-generated method stub
		try{
		return userDAO.getUsersCredentials(username, password);
		}
		catch(NullPointerException e){
		MyLogFile.writeToFile("Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
		}
	}
}
