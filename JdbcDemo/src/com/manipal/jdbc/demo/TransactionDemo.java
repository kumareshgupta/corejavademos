package com.manipal.jdbc.demo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");				
			
			conn.setAutoCommit(false);			
			
			Statement statement = conn.createStatement();			
			
			String query1 = "UPDATE ACCOUNT SET BALANCE = BALANCE - 2000 WHERE ACCNO=111";
			String query2 = "UPDATE ACCOUNT SET BALANCE = BALANCE + 2000 WHERE ACCNO =222";
			
			statement.executeUpdate(query1);
			statement.executeUpdate(query2);
						
			conn.commit();
			System.out.println("Transaction is commited successfully");
					
			//Step 6 : close Connection
			statement.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				conn.rollback();
				System.out.println("Transaction is rolled back...");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
			//e.printStackTrace();
			
		}
		
		
	}

}
