package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
	//Database connection, get the connection
	String driver = "com.mysql.jdbc.Driver";
	String url ="jdbc:mysql://localhost:33006/edudb";
	String un="root";
	String pass ="root";
	Connection conn =null;
	
	public Connection getConnection() {
		// TODO Auto-generated method stub
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,un,pass);
				
			}catch(Exception e) {
				e.printStackTrace();
				
		}
		if(conn==null) {
			System.out.println("Connection Error");
		}
		return null;
	}


}
