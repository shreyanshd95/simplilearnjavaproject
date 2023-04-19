package com.simplilearn.email.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmailValidator {


	
	public static void main(String[] args) {
		// Email Validation
		System.out.println(" Email check validation");
		//store input from scanner
	Scanner emailInp = new Scanner(System.in);
	//Declare object
	String inputUserEmail = emailInp.next();
	
	System.out.println(" Email provide By user " + inputUserEmail);
	
	List<String> emailList = new ArrayList<>();
	emailList.add("zxc@hotmail.com");
	emailList.add("bnm@gmail.com");
	emailList.add("qwe@rediff.com");
	emailList.add("zxc@outlook.com");
	
	System.out.print("email adress list " + emailList );
	
	EmailValidator emailValidator = new EmailValidator();
	
	String emailValidationStatus = emailValidator.checkForValidEmailAddress(inputUserEmail,emailList);
	
	System.out.println( emailValidationStatus );
		 
	 }
	

	private String checkForValidEmailAddress(String userEmail, List<String> validEmailList) {
		String status;
	
		for(int index = 0;index < validEmailList.size();index++ ) {
			if(validEmailList.get(index).equals(userEmail)) {
				status =  userEmail  + "\n is valid";
				return status;
			}
			
		}
		status = userEmail +  "\n is not velid" ;
		return status;
	}
}
