package com.example.test2;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.json.JSONObject;





public class homeworkserver {
	
	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		ServerSocket ss=new ServerSocket(9000);
		while(true){

			Socket s=ss.accept();
			JSONObject person=new JSONObject();
			person.put("id", 99);
			String a1=person.toString();
			OutputStream out=s.getOutputStream();
			
			out.write(a1.getBytes());
			out.close();

			s.close();

}
}}