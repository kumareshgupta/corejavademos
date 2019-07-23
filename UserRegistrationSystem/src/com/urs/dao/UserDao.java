package com.urs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {

	public String getUserDetails(int userId){
		String name = null;
		try {
			//Step 1 : Register a driver
			Class.forName("oracle.jdbc.OracleDriver");
			//Step 2 : Establish a Connection
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			//Step 3 : Create Statement
			Statement statement = conn.createStatement();
			//Step 4 : Execute Query
			String query = "SELECT FIRSTNAME FROM USERS WHERE USERID="+userId;
			ResultSet resultSet = statement.executeQuery(query);
			
			if(resultSet.next()){
				name = resultSet.getString(1);
			}
			//Step 6 : close Connection
			statement.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return name;
	}
}
