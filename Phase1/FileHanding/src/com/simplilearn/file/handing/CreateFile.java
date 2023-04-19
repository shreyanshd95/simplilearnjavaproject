package com.simplilearn.file.handing;
import java.io.File;
import java.io.IOException;
public class CreateFile {

	public static void main(String[] args) {
		// Create directory
		
		File f1 = new File("C:/Users/shreyansh Dwivedi/Desktop/New folder/fileSample.txt");
		try {
			if(f1.createNewFile()) {
				System.out.println("file" + f1.getName()+ " is created Successfully");
			
			}
		} catch(IOException e) {
			System.out.println("file Creation error due to exception");
		}
		
	}
}