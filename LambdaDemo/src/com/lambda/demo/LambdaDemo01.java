package com.lambda.demo;

interface IFunOne{
	void doSomething();	
}

interface IFunTwo{
	void showMe(String message);
}

interface IFunThree{
	void sumEvenOrOdd(int num1, int num2);
}

public class LambdaDemo01 {

	public static void main(String[] args) {
		IFunOne fRef1 = ()->System.out.println("Doing something EXCITING..");
		fRef1.doSomething();	
		
		IFunTwo fRef2 = (String message) -> System.out.println(message);
		fRef2.showMe("Lambda is Interesting Stuff!!");
		
		IFunThree fRef3 = (int num1, int num2) -> {
			int result = num1 + num2;
			if(result%2 == 0)
				System.out.println(result + " -> Sum is Even");
			else
				System.out.println(result + " -> Sum is Odd");
		};
	}
}
