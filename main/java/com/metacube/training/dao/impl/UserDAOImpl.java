package com.metacube.training.dao.impl;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.UserDAO;
import com.metacube.training.log.MyLogFile;
import com.metacube.training.mapper.UserMapper;
import com.metacube.training.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

private JdbcTemplate jdbcTemplate;
	
private final String SQL_FIND_PROJECT = "select * from user where id = ?";
private final String SQL_DELETE_PROJECT = "delete from user where id = ?";
private final String SQL_UPDATE_PROJECT = "update user set first_name = ?, last_name = ?, contact_no  = ?, email  = ? where id = ?";
private final String SQL_GET_ALL = "select * from user";
private final String SQL_INSERT_PROJECT = "insert into user(first_name, last_name, contact_no, email) values(?,?,?,?)";


	@Autowired
	public UserDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean add(User user) {
		try{
		return jdbcTemplate.update(SQL_INSERT_PROJECT, user.getFirstName(), user.getLastName(), user.getContactNo(),
				user.getEmail()) > 0;
		}catch(DataAccessException e){
			MyLogFile.writeToFile("Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
			return false;
		}
	}

	@Override
	public User get(Integer id) {
		try{
			return jdbcTemplate.queryForObject(SQL_FIND_PROJECT, new Object[] { id }, new UserMapper());
	}catch(DataAccessException e){
		MyLogFile.writeToFile("Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
		return null;
	}
	}

	@Override
	public boolean update(User user) {
		try{
			return jdbcTemplate.update(SQL_UPDATE_PROJECT, user.getFirstName(), user.getLastName(), user.getContactNo(),
				user.getLastName(),user.getId()) > 0;
		}
				catch(DataAccessException e){
					MyLogFile.writeToFile("Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
					return false;
				}	
	}

	@Override
	public List<User> getAll() {
		try{
			return jdbcTemplate.query(SQL_GET_ALL, new UserMapper());
		}
		catch(DataAccessException e){
			MyLogFile.writeToFile("Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
			return null;
		}
	}

	@Override
	public boolean delete(Integer id) {
		try{
			return jdbcTemplate.update(SQL_DELETE_PROJECT, id) > 0;
		}
		catch(DataAccessException e){
			MyLogFile.writeToFile("Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
			return false;
		}
	}
	@Override
	public List<User> getByAttribute(String attribute, String value){
		try{
	       return jdbcTemplate.query("select * from user where "+attribute +"=\""+ value +"\";"  ,new UserMapper());
	   }
		catch(DataAccessException e){
			MyLogFile.writeToFile("Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
			return null;
		}
}
}
