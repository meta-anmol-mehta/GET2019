package com.metacube.training.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.FileHandler;


import com.metacube.training.log.MyLogFile;

/**
* This class is used to create connection pool
* 
* @author Anmol mehta
*
*/

public class MyConnectionManager {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/EAD2";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "@nmolM123";
  

	public static Connection getConnection() {
		
		
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			MyLogFile.writeToFile("Errorcode:"+e.getErrorCode()+"Mesage:"+e.getMessage()+"Time:"+new Date()+"\n");
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			MyLogFile.writeToFile("Message:"+e1.getMessage()+"Time:"+new Date()+"\n");
			
		}
		return con;

	}

}
