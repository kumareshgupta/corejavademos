package com.manipal.jdbc.demo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessingDemo {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");			
			Statement statement = conn.createStatement();
			
			
			String query1 = "INSERT INTO LIBRARY VALUES(470,'Enjoy JSTL',300.00,'Ratnam')";
			String query2 = "UPDATE LIBRARY SET PRICE=PRICE+PRICE*.1 WHERE PRICE>200 and PRICE<900";
			
			statement.addBatch(query1);
			statement.addBatch(query2);
			
			int[] status = statement.executeBatch();
			statement.close();
			
			System.out.println(status[0] + " rows affected by insert query");
			System.out.println(status[1] + " rows affected by update query");
			
			//Step 6 : close Connection
			
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
