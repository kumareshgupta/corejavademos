package com.manipal.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementDemo {

	public static void main(String[] args) {
				try {
					Class.forName("oracle.jdbc.OracleDriver");					
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
					String query = "INSERT INTO LIBRARY VALUES(?,?,?,?)";
					PreparedStatement pStatement = conn.prepareStatement(query);						
					pStatement.setInt(1, 345);
					pStatement.setString(2, "Learn Agile");
					pStatement.setDouble(3, 222.55);
					pStatement.setString(4, "Mathumitha");
					int noOfRows = pStatement.executeUpdate();
					System.out.println("Rows inserted " + noOfRows);
					pStatement.close();
					conn.close();
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}

	}

}
