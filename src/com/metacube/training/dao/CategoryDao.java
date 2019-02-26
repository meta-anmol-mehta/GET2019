package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.metacube.training.database.MyConnectionManager;
import com.metacube.training.database.MyDatabaseQueries;
import com.metacube.training.enums.Status;
import com.metacube.training.log.MyLogFile;
import com.metacube.training.model.Category;

/**
 * CategoryDao is for performing insertion , deletion and update operations on
 * category table
 */
public class CategoryDao implements BaseDao<Category> {

	private Connection con;
	private String query;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	@Override
	public List<Category> getList() {
		// TODO Auto-generated method stub
		List<Category> categoryList = new ArrayList<Category>();
		try {
			con = MyConnectionManager.getConnection();
			query = MyDatabaseQueries.GET_ALL_CATEGORY;
			preparedStatement = con.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Category category = new Category();
				category.setId(resultSet.getInt(1));
				category.setName(resultSet.getString(2));
				categoryList.add(category);
			}
		} catch (SQLException e) {
			MyLogFile.writeToFile("Errorcode:"+e.getErrorCode()+"Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
			}

		return categoryList;
	}

	@Override
	public Status insert(Category entity) {
		try {
			con = MyConnectionManager.getConnection();
			query = MyDatabaseQueries.INSERT_CATEGORY;
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, entity.getId());
			preparedStatement.setString(2, entity.getName());
			preparedStatement.executeUpdate();
			con.close();
			return Status.INSERTED;
		} catch (SQLException e) {
			MyLogFile.writeToFile("Errorcode:"+e.getErrorCode()+"Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
			return Status.ERROR;
		}
	}

	@Override
	public Status delete(int id) {
		// TODO Auto-generated method stub
		try {
			con = MyConnectionManager.getConnection();
			query = MyDatabaseQueries.DELETE_CATEGORY;
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			return Status.DELETED;
		} catch (SQLException e) {
			MyLogFile.writeToFile("Errorcode:"+e.getErrorCode()+"Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
			return Status.ERROR;
		}
	}

	@Override
	public Status update(Category entity) {
		// TODO Auto-generated method stub
		try {
			con = MyConnectionManager.getConnection();
			query = MyDatabaseQueries.UPDATE_CATEGORY;
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(2, entity.getId());
			preparedStatement.setString(1, entity.getName());
			preparedStatement.executeUpdate();
			return Status.UPDATED;
		} catch (SQLException e) {
			MyLogFile.writeToFile("Errorcode:"+e.getErrorCode()+"Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
			return Status.ERROR;
		}

	}

}
