package com.simplilearn.functions;

public class FunctionsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FunctionsExample funObj = new FunctionsExample();
		funObj.function1(); //calling non parameterized void functionand will get the result based on the parameters passed
		funObj.function1(); // calling overloading parametered function and will get the result based on the parameters passed
		long resultFunction2 = funObj.function2(); //calling non-parameterized log return type function,always gets same result
		long resultOverloadedFunction2 = funObj.function2(30,40); //calling overloaded parameterized long returntype function and will get result on parameter passed
		System.out.println("result Function ==>  " + resultFunction2);
		System.out.println("result Overloaded Function ==> "+ resultOverloadedFunction2);
		
	}
	
		
	
	//public non-parameterized function with void return type (meaning this function does not return anything)
	public void function1() {
		int val1 = 15;
		int val2 = 60;
		System.out.println("resultFuntion1 ==> " + (val1 + val2));
	}
	// public non-parameterized function with some return type (like long)
	public long function2() {
		long val1 = 15;
		long val2 = 60;
		return val1 + val2;
	}
	//public parameterized return with void return type (meaning this function does not return anything)
	//this is an overloaded function1
	public  void function(int val1,int val2) {
		System.out.println("resultOverloadedFunction1 ==> "+(val1 + val2));
	}
	//public parameterized function with some return type(like long)
	//this is an overloading function2
	public long function2(long val1 , long val2) { 
	
		return val1 + val2;
		
	}
}
