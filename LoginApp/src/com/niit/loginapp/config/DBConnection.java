package com.niit.loginapp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String username= "sa";
	private static String password= "sa";
	private static String url= "jdbc:h2:tcp://localhost/~/test";
	private static String driver= "org.h2.Driver";
	
	public static Connection getDBConnection(){
		Connection con= null;
		try{
			Class.forName(driver);
			con= DriverManager.getConnection(url,username, password);
			}
		catch(ClassNotFoundException e){
			//TODO Auto generated catch block
			e.printStackTrace();
	        }
		catch(SQLException e){
			//Auto generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args){
		if (getDBConnection ()== null)
		{
			System.out.println("Couldnot connect to Database");
		}
		else
		{
			System.out.println("Successfully connected to db");
		}
	}

}
