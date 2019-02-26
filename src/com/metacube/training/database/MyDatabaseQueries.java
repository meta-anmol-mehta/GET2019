package com.metacube.training.database;

/**
 * 
 * allt he queries we are using in this assignment
 * 
 * @author anmol
 *
 */

public class MyDatabaseQueries {

	public static final String GET_ALL_ADVERTISEMENT = "SELECT * FROM advertisement";
	public static final String GET_ALL_CATEGORY = "SELECT * FROM category";
	public static final String FIND_ADVERTISEMENT = "SELECT * FROM advertisement where advertisementID=?";
	public static final String FIND_CATEGORY = "SELECT * FROM category where categoryID=?";
	public static final String INSERT_ADVERTISEMENT = "INSERT INTO advertisement (advertisementID,advertisementTitle, advertisementDesc , categoryID) VALUES (?,?,?,?)";
	public static final String INSERT_CATEGORY = "INSERT INTO category (categoryID,categoryName) VALUES (?,?)";
	public static final String UPDATE_CATEGORY = "UPDATE category SET categoryName = ? WHERE categoryID = ? ";
	public static final String UPDATE_ADVERTISEMENT = "UPDATE advertisement SET advertisementTitle = ?,advertisementDesc=? WHERE advertisementID = ? ";
	public static final String DELETE_ADVERTISEMENT = "DELETE FROM advertisement WHERE advertisementID = ? ";
	public static final String DELETE_CATEGORY = "DELETE FROM category WHERE categoryID = ? ";

}
