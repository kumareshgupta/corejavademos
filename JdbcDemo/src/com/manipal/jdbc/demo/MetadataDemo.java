package com.manipal.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MetadataDemo {

	public static void main(String[] args) {
		//Register a driver
		try {
			//Step 1 : Register a driver
			Class.forName("oracle.jdbc.OracleDriver");
			//Step 2 : Establish a Connection
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			//Step 3 : Create Statement
			Statement statement = conn.createStatement();
			//Step 4 : Execute Query"INSERT INTO LIBRARY VALUES(101,'Learn Clean Coding',100.00,'Manikandhan')");
			ResultSet resultSet = statement.executeQuery("SELECT BOOKID,TITLE FROM LIBRARY");
			//Step 5 : Process the result
			while(resultSet.next()){
				int bookId = resultSet.getInt(1);
				String bookTitle =  resultSet.getString(2);
				System.out.println(bookId + "\t" + bookTitle);
			}
			
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
