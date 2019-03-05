package com.metacube.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.interfaces.UserService;
import com.metacube.training.model.User;
import com.metacube.training.model.UserCredential;
import com.metacube.training.repository.UserCredentialRepository;
import com.metacube.training.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	private UserCredentialRepository userCredentialRepository;

	@Override
	public boolean add(User user) {

		if(userRepository!=null)
		if(userRepository.save(user)!=null){
			return true;
		}
		return false;

	}

	@Override
	public User get(Integer id) {

		return userRepository.findOne(id);

	}

	@Override
	public boolean update(User user) {

		if(userRepository!=null)
		if(userRepository.save(user)!=null){
			return true;
		}
		return false;
	}

	@Override
	public List<User> getAll() {

		if(userRepository!=null)
		return userRepository.findAll();
		return null;

	}

	@Override
	public boolean delete(Integer id) {

		if(userRepository!=null)
			userRepository.delete(id);
		return true;
	}

	@Override
	public List<User> getByAttribute(String attribute, String value) {

		if(userRepository!=null)
		{
		 try {
	            if (attribute.equals("first_name"))
	                return userRepository.findAllByFirstName(value);
	            else if (attribute.equals("last_name"))
	                return userRepository.findAllByLastName(value);
	            else if (attribute.equals("contact_no"))
	                return userRepository.findAllByContactNo(value);
	            else if (attribute.equals("email"))
	                return userRepository.findAllByEmail(value);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		}
		 return null;
		
	}

	@Override
	public boolean getUsers(String username, String password) {
		// TODO Auto-generated method stub

		if(userCredentialRepository!=null)
		if(userCredentialRepository.findOne(username)==null){
			userCredentialRepository.save(new UserCredential(username, password));
		}
		return true;

	}
}
