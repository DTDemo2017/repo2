package com.niit.loginapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.niit.loginapp.config.DBConnection;

public class LoginDAO {
	public boolean isValidCredentials(String id, String password)
	{
		//Get the connection
		Connection con= DBConnection.getDBConnection();
		
		//write query
		try{
			PreparedStatement pStatement= con.prepareStatement("select * from TUSER where id=? and password=?");
			pStatement.setString(1,  id);
			pStatement.setString(2,  password);
			
		//execute query
			ResultSet resultSet= pStatement.executeQuery();
			if(resultSet.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return true;
	}
	


public static void main(String[] args){
			createRecord("Indranil", "Indranil");
		}
//inserting the record
public static void createRecord (String id, String password)
{
Connection con =DBConnection.getDBConnection ();
		try{
				Statement statement= con.createStatement();
				//insert into TUSER(id, password) values('Animesh', 'Jain')
				String query= "insert into TUSER(id, password)" + "values ('"+id+"','"+password+"')";
				System.out.println("query:" +query);
				statement.executeUpdate(query);
			}
			catch (SQLException e){
				//TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	

			
		
		
		    //get all users
			//want to display all users
			public static String getAllUsers()
			{
				Connection con1= DBConnection.getDBConnection();
				try{
					Statement statement= con1.createStatement();
					ResultSet resultSet= statement.executeQuery("select * from tuser");
					while(resultSet.next())
					{
						System.out.println(resultSet.getString(1)+ "\t");
						System.out.println(resultSet.getString(2));
					}
				}
					catch(SQLException e){
						//TODO Auto-generated catch block
						e.printStackTrace();
					}
				return null;
				}
			
		
		

}
