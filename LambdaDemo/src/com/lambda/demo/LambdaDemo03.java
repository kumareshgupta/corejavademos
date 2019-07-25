package com.lambda.demo;

interface IFunFour{
	int multiply(int num1,int num2);
}

public class LambdaDemo03 {
	public static void main(String[] args) {
		//Lambda Expression with multiple parameters
		IFunFour iRef = (num1, num2)->{
			return (num1 * num2);
		};
		
		int result = iRef.multiply(100, 200);		
		System.out.println("Multiplication : " + result);
	}
}
