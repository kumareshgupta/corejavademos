package com.manipal.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDataMain {
	public static void main(String[] args) {

		try {
			//Step 1 : Register a driver
			Class.forName("oracle.jdbc.OracleDriver");
			//Step 2 : Establish a Connection
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			//Step 3 : Create Statement
			Statement statement = conn.createStatement();
			//Step 4 : Execute Query
			int noOfRowsInserted = 
					statement.executeUpdate("INSERT INTO LIBRARY VALUES(101,'Learn Clean Coding',100.00,'Manikandhan')");
			System.out.println("Rows inserted : "  + noOfRowsInserted);			
			
			//Step 6 : close Connection
			statement.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}

}
