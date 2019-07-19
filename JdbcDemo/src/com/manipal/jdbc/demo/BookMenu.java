package com.manipal.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BookMenu {		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int option = 0;
		do{
			System.out.println("1. Add Book Details");
			System.out.println("2. Update Book Details");
			System.out.println("3. Display Book Details");
			System.out.println("4. Delete Details");
			System.out.println("5. Exit");
			System.out.println("Enter your choice");
			option = scanner.nextInt(); scanner.nextLine();
			switch(option){
			case 1 : System.out.println("--------Add Book Details ---------");
				addBooks();
				break;
			case 2 : System.out.println("--------Update Book Details ---------");
				updateBooks();
			break;
			case 3 : System.out.println("--------Display Book Details ---------");
			break;
			case 4 : System.out.println("--------Delete Book Details ---------");
			break;
			case 5 : System.exit(0);
			break;
			default : System.out.println("--------Invalid Option---------\n Choose option from 1 to 5 only");
			break;
			}

		}while(option!=5);

	}

	private static void updateBooks() {
		// TODO Auto-generated method stub
		System.out.println("Write update code here.....");
		
	}

	public static void addBooks(){
		Scanner scanner = new Scanner(System.in);
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
