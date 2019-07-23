package com.lambda.demo;

import java.util.ArrayList;

public class LambdaDemo02 {
	public static void main(String [] args){
		ArrayList<String> movies = new ArrayList<String>(); 
		movies.add("Bahubali");
		movies.add("Mangal Mission");
		movies.add("Super 30");		
		movies.add("Robot");
		
		movies.forEach(movie->System.out.println(movie));
		
		movies.forEach(movie -> {
			int n = movie.length();
			System.out.println(movie.toUpperCase() + " " + n);
		});
		
	}
}
