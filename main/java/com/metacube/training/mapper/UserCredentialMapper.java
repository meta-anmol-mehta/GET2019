package com.metacube.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.log.MyLogFile;
import com.metacube.training.model.User;
import com.metacube.training.model.UserCredential;

/**
 * map the user credential table from db 
 * @author admin
 *
 */
public class UserCredentialMapper implements RowMapper<UserCredential> {

	@Override
	public UserCredential mapRow(ResultSet resultSet, int i) throws SQLException {

		UserCredential project = new UserCredential();
		
		try{

			
			project.setUsername(resultSet.getString("username"));
			project.setPassword(resultSet.getString("password"));
			
		}
		catch(SQLException e){
			MyLogFile.writeToFile("Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
		}
		
		return project;
	}
}
