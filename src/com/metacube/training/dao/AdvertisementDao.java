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
import com.metacube.training.model.Advertisement;
import com.metacube.training.model.BaseEntity;

/**
 * AdvertisementDao is for performing different operations like insertion ,
 * deletion and update operations on advertisement table
 */

public class AdvertisementDao implements BaseDao<Advertisement> {

	private Connection con;
	private String query;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	@Override
	public List<Advertisement> getList() {

		List<Advertisement> advertisementList = new ArrayList<Advertisement>();
		try {
			con = MyConnectionManager.getConnection();
			query = MyDatabaseQueries.GET_ALL_ADVERTISEMENT;
			preparedStatement = con.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Advertisement advertisement = new Advertisement();
				advertisement.setId(resultSet.getInt(1));
				advertisement.setTitle(resultSet.getString(2));
				advertisement.setDescription(resultSet.getString(3));
				advertisementList.add(advertisement);
			}
		} catch (SQLException e) {
			MyLogFile.writeToFile("Errorcode:"+e.getErrorCode()+"Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
		}

		return advertisementList;

	}

	@Override
	public Status insert(Advertisement entity) {

		try {
			con = MyConnectionManager.getConnection();
			query = MyDatabaseQueries.INSERT_ADVERTISEMENT;
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, entity.getId());
			preparedStatement.setString(2, entity.getTitle());
			preparedStatement.setString(3, entity.getDescription());
			resultSet = preparedStatement.executeQuery();
			return Status.INSERTED;
		} catch (SQLException e) {
			MyLogFile.writeToFile("Errorcode:"+e.getErrorCode()+"Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
			return Status.ERROR;
		}

	}

	@Override
	public Status delete(int id) {
		try {
			con = MyConnectionManager.getConnection();
			query = MyDatabaseQueries.DELETE_ADVERTISEMENT;
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			return Status.DELETED;
		} catch (SQLException e) {
			MyLogFile.writeToFile("Errorcode:"+e.getErrorCode()+"Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
			return Status.ERROR;
		}
	}

	@Override
	public Status update(Advertisement entity) {

		try {
			con = MyConnectionManager.getConnection();
			query = MyDatabaseQueries.UPDATE_ADVERTISEMENT;
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, entity.getId());
			preparedStatement.setString(2, entity.getTitle());
			preparedStatement.setString(3, entity.getDescription());
			resultSet = preparedStatement.executeQuery();
			return Status.UPDATED;
		} catch (SQLException e) {
			MyLogFile.writeToFile("Errorcode:"+e.getErrorCode()+"Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
			return Status.ERROR;
		}

	}

}
