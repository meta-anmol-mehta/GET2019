package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * user credential entity class
 * 
 * @author admin
 *
 */

@Entity
@Table(name = "usercredential")
public class UserCredential {

	@Id
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;

	public UserCredential(String username, String password) {

		this.username = username;
		this.password = password;
	}

	public UserCredential() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
