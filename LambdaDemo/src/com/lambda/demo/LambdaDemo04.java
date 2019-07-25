package com.lambda.demo;

interface IFunFive{
	public void display(String message);
}
public class LambdaDemo04 {

	public static void main(String[] args) {
		//Lambda Expression
		IFunFive iRef1 = message -> System.out.println(message);
		iRef1.display("Lambda Expression is Easy.");
		
		// Method Reference
		IFunFive iRef2 = System.out::println; 
		iRef2.display("Replacing Lambda with Method Reference");
	}

}
