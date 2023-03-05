package com.simplilearn.email;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MailVerification {

	
		public static void main(String[] args) {
		//Email verification in the given name
		System.out.println("Email verification");
		
		Scanner userMail = new Scanner(System.in);
		
		String inputUserMail = userMail.next() ;
		
		System.out.println("Input email adress form User\n" + userMail);
		
		List <String> emailLis = new ArrayList<>();
		emailLis.add("abc@gmail.com");
		emailLis.add("xyz@hotmail.com");
		emailLis.add("qwe@redif.com");
		emailLis.add("vbe@outlook.com");
		emailLis.add("mar@gmail.com");
		System.out.println("Available Email ID" + emailLis);
		
		
}
}