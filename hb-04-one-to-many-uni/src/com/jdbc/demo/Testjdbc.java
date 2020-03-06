package com.jdbc.demo;


import java.sql.Connection;
import java.sql.DriverManager;

public class Testjdbc {

	public static void main(String[] args) {
		
		String jdbcurl = "jdbc:mysql://localhost:3306/hb-04-one-to-many-uni";
		String user="root";
		String password="!QAZ1qaz";
		
		try {
			
			System.out.println("connecting to database" +jdbcurl);
			
			Connection myCon = DriverManager.getConnection(jdbcurl,user,password);
			
			System.out.println(myCon);
			
		}catch(Exception exc){
			exc.printStackTrace();
		}

	}

}
