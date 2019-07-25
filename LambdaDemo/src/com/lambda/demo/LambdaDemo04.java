package com.lambda.demo;

interface IFunFive{
	public void display(String message);
}

interface IFunSix{
	public double getPower(double num, double power);
}
public class LambdaDemo04 {

	public static void main(String[] args) {
		//Lambda Expression
		IFunFive iRef1 = message -> System.out.println(message);
		iRef1.display("Lambda Expression is Easy.");
		
		// Method Reference
		//System.out::println equivalent to message -> System.out.println(message)
		IFunFive iRef2 = System.out::println; 
		iRef2.display("Replacing Lambda with Method Reference");
		
		//Another example : Method Reference
		IFunSix iRef3 = Math::pow;
		System.out.println(iRef3.getPower(10, 2));
		
	}

}
