package com.simplilearn.functions;

public class MethodOverloadingExample {

	public static void main(String[] args) {
	
		MethodOverloadingExample methoverloadobj = new MethodOverloadingExample();
		System.out.println(methoverloadobj.addition(30 , 20));
		System.out.println(methoverloadobj.addition(30 , 20 , 10));
		System.out.println(methoverloadobj.multiplication(10 , 5));
		System.out.println(methoverloadobj.multipication(3.5 , 35.5));
		}
		
		// overloaded method example
		
		//Overloaded Method - when the number of the Parameter are different
		//Overloading Method - when the data type of parameter are different
		//not Overloading or Duplicate Method - when the return types are different
		
		//Example-1 when the number of parameter is different
		public int addition(int a,int b) {
			System.out.println("inside addition function with 2 parameter....");
			return a + b;	
		}
		public int addition(int a, int b, int c) {
			System.out.println("inside addition function with 3 parameter.....");
			return a + b + c;
		}
		
		// Example-2 when the data type of parameter is different
		public int multiplication(int a,int b) {
			System.out.println("inside multiplication funtion with 2 parameter .....");
			return a * b;	
		}
		public double multipication(double a, double b) {
			System.out.println("inside substaction funtion with 2 double type......");
			return a - b;
		}
	
		//Example-3 Non overload -when the return types are different
		// but the name are same and the parameter are also same
//		public int substartion(int a,int b) {
//			System.out.println("inside substation funtion with 2 parameter .....");
//			return  (a - b);	
//		}
//		public double substartion1(int a, int b) {
//			System.out.println("inside substaction funtion with 2 double type......");
//			return a - b;

		
		
		
	
		
}
