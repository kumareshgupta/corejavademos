package com.manipal.jdbc.demo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcMain {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			DatabaseMetaData dMetaData =  conn.getMetaData();
			
			System.out.println(dMetaData.getDatabaseProductName() + "\n" + dMetaData.getDatabaseProductVersion());
			System.out.println(dMetaData.getDatabaseMajorVersion() + "\n" +dMetaData.getDatabaseMinorVersion());
			System.out.println(dMetaData.getDriverName() + "\n" + dMetaData.getDriverVersion());
			
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT BOOKID,TITLE FROM LIBRARY");
			ResultSetMetaData rSetMetaData = resultSet.getMetaData();
			System.out.println("Table name : " + rSetMetaData.getTableName(1));
			System.out.println(rSetMetaData.getColumnCount());
			System.out.println(rSetMetaData.getColumnName(2) + "\t" + rSetMetaData.getColumnDisplaySize(2));
			System.out.println(rSetMetaData.isNullable(2));
			
			/*while(resultSet.next()){
				int bookId = resultSet.getInt(1);
				String bookTitle =  resultSet.getString(2);
				System.out.println(bookId + "\t" + bookTitle);
			}*/
			
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
