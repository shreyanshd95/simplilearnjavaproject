package com.simplilearn.file.handing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
public static void main(String[] args) { 
	//Read file
	File f1 = new File("C:/Users/shreyansh Dwivedi/Desktop/New folder/fileSample.txt");
	try {
			Scanner fileReader = new Scanner(f1);
			
			while(fileReader.hasNextLine()) {
				String fileData = fileReader.nextLine();
				System.out.println(fileData);
			}
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	
	}


	
}
