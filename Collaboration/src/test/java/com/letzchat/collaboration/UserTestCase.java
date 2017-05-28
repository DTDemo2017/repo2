package com.letzchat.collaboration;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.letzchat.collaboration.dao.BlogDAO;
import com.letzchat.collaboration.dao.UsersDAO;
import com.letzchat.collaboration.model.Blog;
import com.letzchat.collaboration.model.Users;

public class UserTestCase {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.letzchat.collaboration");
		context.refresh();
		
		UsersDAO usersDAO=(UsersDAO)context.getBean("usersDAO");
		
        /*Users users= new Users();
		
		users.setUserid(1003);
		users.setFirstname("Ashwini");
		users.setLastname("Kumari");
		users.setPassword("ashwini");
		users.setEmailid("ashwinikumari123@gmail.com");
		users.setRole("Student");
		users.setStatus("NA");
		users.setIsonline("Y");
		
		usersDAO.insertUsers(users);
		System.out.println("User Details Added");*/
		
		 Users users= new Users();
		
		users.setUserid(1004);
		users.setFirstname("Ashmita");
		users.setLastname("Kumari");
		users.setPassword("ashmita");
		users.setEmailid("ashmitakumari@yahoo.in");
		users.setRole("Alumni");
		users.setStatus("APPROVE");
		users.setIsonline("Y");
		
		usersDAO.insertUsers(users);
		System.out.println("User Details Added");
		
		//Retrieve the users
		/*List<Users> users= usersDAO.getAllUsers();
		for (Users u: users)
		{
			System.out.println(u.getUserid()+ ":");
			System.out.println(u.getFirstname()+ ":");
			System.out.println(u.getLastname()+ ":");
			System.out.println(u.getPassword()+ ":");
			System.out.println(u.getEmailid()+ ":");
			System.out.println(u.getRole()+ ":");
			System.out.println(u.getStatus()+ ":");
			System.out.println(u.getIsonline()+ ":");
		}*/
		
		//Deleting a User
		/*usersDAO.deleteUsers(1003);
		System.out.println("Users Deleted");*/
		
		
		//Change value of a column in Users
		/*Users users1=usersDAO.getUsers(1003);
		users1.setStatus("APPROVE");
		usersDAO.insertUsers(users1);
		System.out.println("Users Updated");*/
		
		
		

	}


	}


