package com.simplilearn.HttpsMethods;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class JavaPOSTExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JavaPOSTExample postObj = new JavaPOSTExample();
		postObj.postRequest();
	}

	public void postRequest() throws IOException{
		// TODO Auto-generated method stub
		
		final String messageContent = "{\n" + "\"UserID\":007,\r\n" + "\"ID\":001, \r\n" + "\"Title\": \"Java Post Request\","
				+ "\"body\": \"Post Request is used to create a resource server side.\"" +"\n}"; 
		
		System.out.println(messageContent);
		
		String url = "https://my-json-server.typicode.com/typicode/demo/posts"; 
		
		URL urlObj = new URL(url);
		
		String Read = null;
		
		HttpURLConnection postConnect = (HttpURLConnection)urlObj.openConnection();
		
		postConnect.setRequestMethod("POST");
		postConnect.setRequestProperty("USER ID","Jarvis");
		postConnect.setRequestProperty("Content-Type","application/json");
		postConnect.setDoOutput(true);
		
		OutputStream outObj = postConnect.getOutputStream();
		outObj.write(messageContent.getBytes());
		outObj.flush();
		outObj.close();
		
		int ResponseCode = postConnect.getResponseCode();
		System.out.println("Response from the server");
		System.out.println("POST Responce code is:" + ResponseCode);
		System.out.println("POST Responce message is:" + postConnect.getResponseMessage());
		
		if(ResponseCode == HttpURLConnection.HTTP_CREATED ) {
		InputStreamReader inp = new InputStreamReader(postConnect.getInputStream());
		BufferedReader br = new BufferedReader(inp);
		String input = null;
		StringBuffer sb =new StringBuffer();
		
		while((input = br.readLine()) != null ){
			sb.append(input);
			}
		
			br.close();
			postConnect.disconnect();
			System.out.println(sb.toString());
		
		}
		else {
			System.out.println("POST Request did't work");
			
			}
			
		}

	}

	
	
	
	
	