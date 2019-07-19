package com.manipal.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BookDataMain {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter book details ");
		System.out.println("Enter Book ID");
		int bookId = scanner.nextInt(); scanner.nextLine();
		System.out.println("Enter Book Title");
		String title = scanner.nextLine();
		System.out.println("Enter Book Price");
		double price = scanner.nextDouble();scanner.nextLine();
		
		System.out.println("Enter Book Author");
		String author = scanner.nextLine();
		
		
		try {
			//Step 1 : Register a driver
			Class.forName("oracle.jdbc.OracleDriver");
			//Step 2 : Establish a Connection
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			//Step 3 : Create Statement
			Statement statement = conn.createStatement();
			//Step 4 : Execute Query
			String query = "INSERT INTO LIBRARY VALUES(" + bookId +",'"+title+"',"+price+",'" + author +"')";
			System.out.println(query);
			int noOfRowsInserted = 
					statement.executeUpdate(query);
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
