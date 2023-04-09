package com.simplilearn.HttpsMethods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JavaGETExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
JavaGETExample getObj = new JavaGETExample();

			getObj.getRequest();


	}

	public void getRequest() throws IOException {
		// TODO Auto-generated method stub

		String url = "Https://www.google.com";
		
		URL urlForRequest = new URL(url);
		
		String Read = null;
		
		HttpURLConnection connection = (HttpURLConnection)urlForRequest.openConnection();
		
		connection.setRequestMethod("GET");
		connection.setRequestProperty("admin","admin");
		
		int ResponseCode = connection.getResponseCode();
		
		if(ResponseCode == HttpURLConnection.HTTP_OK)
		{
			InputStreamReader isrObj = new InputStreamReader(connection.getInputStream());
			
			BufferedReader bf = new BufferedReader(isrObj);
			
			StringBuffer responseStr = new StringBuffer();
			
			while((Read = bf.readLine()) != null) {
				responseStr.append(Read);
				
			}
			
			bf.close();
			connection.disconnect();
			
			System.out.println("HTML String Result is:\n" + responseStr);
			
		}
		else {
			System.out.println("GET Request didn't work");
		}
		
		
	}

}
	
		
		
		
		
		
		
		
		
	