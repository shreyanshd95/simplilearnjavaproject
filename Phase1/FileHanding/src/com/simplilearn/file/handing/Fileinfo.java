package com.simplilearn.file.handing;
import java.io.File;
public class Fileinfo {

	public static void main(String[] args) {
		// File information 
		
		File f1 = new File("C:/Users/shreyansh Dwivedi/Desktop/New folder/fileSample.txt");
		if(f1.exists()) {
			System.out.println(f1.getName());
			System.out.println(f1.getAbsolutePath());
			System.out.println(f1.canRead());
			System.out.println(f1.canWrite());
			System.out.println(f1.length());
			System.out.println(f1.isFile());
			
	}
	
		else {
			System.out.println("file doesn't exists");
		}
	}
}