package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	 public List<User> findAllByFirstName(String value);
	    public List<User> findAllByLastName(String value);
	    public List<User> findAllByContactNo(String value);
	    public List<User> findAllByEmail(String value);

}
