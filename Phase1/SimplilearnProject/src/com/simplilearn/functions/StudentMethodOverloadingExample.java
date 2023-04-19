package com.simplilearn.functions;


public class StudentMethodOverloadingExample extends PersonalMethodOverloadingExample{

	public static void main(String[] args) {
		// Realworld Example of method overloading
		StudentMethodOverloadingExample stud = new StudentMethodOverloadingExample();
		stud.work();
	}
	
	//here we have created similar work fuction as that of person work function , so we overriding the work function
	public void work() {
		System.out.println("the more you work towards your goal the early you will get the Success ....");
	}

}
