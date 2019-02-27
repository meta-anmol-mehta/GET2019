package com.metacube.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.log.MyLogFile;
import com.metacube.training.model.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet resultSet, int i) throws SQLException {

		User project = new User();
		try{

			
			project.setId(resultSet.getLong("id"));
			project.setFirstName(resultSet.getString("first_name"));
			project.setLastName(resultSet.getString("last_name"));
			project.setContactNo(resultSet.getString("contact_no"));
			project.setEmail(resultSet.getString("email"));
			
		}
		catch(SQLException e){
			MyLogFile.writeToFile("Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
		}
		return project;
	}
}
