package com.simplilearn.file.handing;


import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

	public static void main(String[] args) {
		// Write letter in extixing text file 
		try {
		
			FileWriter fWrite = new FileWriter("C:/Users/shreyansh Dwivedi/Desktop/New folder/fileSample.txt");
			fWrite.write("hello! this is sample of write file handling  ");
			fWrite.close();
			System.out.println("sucessfully write in file ");
		
		}catch (IOException e) {
			System.out.println("unexpected error...");
			e.printStackTrace();
		}
	}

}
