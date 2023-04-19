package com.simplilearn.arithmetic.calculator;

import java.util.Scanner;

public class ArithmaticCalculator {

	public static void main(String[] args) {
		
//Arithmetic Calculator is very useful it easy & Fast our calculation work 
		//Scanner object creation for take input
		Scanner num1 =new Scanner(System.in);
		Scanner num2 =new Scanner(System.in);
		

	System.out.println("Enter Number for Arithmatic calculations :");
	
		//getting value from scanner
		double number1 = num1.nextDouble();
		double number2 = num2.nextDouble();
		
		System.out.println("First value Enter by User " + number1);
		System.out.println("Second value Enter by User " + number2);
		
		//create an object of a class to call the Arithmetic operation
		
		ArithmaticCalculator arithCalc = new ArithmaticCalculator();
		
		double additionResult = arithCalc.addition(number1,number2); //calling addition operations
	
		double subtractionResult = arithCalc.Subtraction(number1,number2); //calling subtraction operations

		double multiplicationResult = arithCalc.multiplication(number1,number2); //calling multiplication operations

		double divisionResult = arithCalc.division(number1,number2); //calling division operations
		
		System.out.println("Arithmetic Operations Results are given below");
		
		System.out.println(number1 + "+" + number2 + "=" + (additionResult));
		
		System.out.println(number1 + "+" + number2 + "=" + (subtractionResult));
	
		System.out.println(number1 + "+" + number2 + "=" + (multiplicationResult));
	
		
		System.out.println(number1 + "+" + number2 + "=" + (divisionResult));
		
	}
	
	//First Arithmetic Operations - Addition
	public double addition(double num1,double num2) {
		return num1 + num2;
	}	
		
	//Second Arithmetic Operations - Subtraction
	public double Subtraction(double num1, double num2) {
			return num1 - num2;	
	}
	
	//Third Arithmetic Operations - multiplication
	public double multiplication(double num1,double num2) {
			return num1 * num2;
	
	}
		
	//Fourth Arithmetic Operations - division
	public double division(double num1,double num2) {
			return num1 / num2;	
		
	
		
		
		
	}
}
