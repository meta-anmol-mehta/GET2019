package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.model.UserCredential;

public interface UserCredentialRepository extends JpaRepository<UserCredential, String>{

	
	
}
