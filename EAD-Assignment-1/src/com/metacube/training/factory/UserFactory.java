package com.metacube.training.factory;

import com.metacube.training.model.UserModel;

public class UserFactory {

	public static UserModel createUser(int id,String name,String mobileNo,String emailAddress){
		return new UserModel(id, name, mobileNo, emailAddress);
	}
	
}
