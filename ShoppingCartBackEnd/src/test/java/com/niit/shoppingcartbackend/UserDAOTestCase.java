package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.UserDAO;
import com.niit.shoppingcartbackend.domain.User;



@SuppressWarnings("deprecation")
public class UserDAOTestCase {

	@Autowired static AnnotationConfigApplicationContext context;
    
	@Autowired static UserDAO userDAO;
	
	@Autowired static User user;
	
	//above objects need to initialize
	@BeforeClass
	public static void initialize()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
		
		
		user=(User)context.getBean("user");
    }
	
	/*@Test
	public void createUserTestCase () {
		
		
		user.setId("jayesh");
		user.setName("jayesh Kumar");
		user.setPassword("jayesh");
		user.setContact("9836264550");
		user.setRole("ROLE_USER");
		boolean flag= userDAO.save(user);
		System.out.println(" ");
		
		assertEquals("createUserTestCase",true,flag);
		
	}*/	
	
	/*@Test
	public void updateUserTestCase () {
		
		
		user.setId("jayesh");
		user.setName("Jayesh");
		user.setPassword("jayesh");
		user.setContact("9836264550");
		user.setRole("ROLE_USER");
		boolean flag= userDAO.update(user);
		System.out.println(" ");
		
		assertEquals("updateUserTestCase",true,flag);
		
	}*/
	
	/*@Test
	public void validateUserTestCase () {
		
		boolean flag=userDAO.validate("kiran", "kiran");
		
		assertEquals(true,flag);
		
	}*/	
	
	/*@Test
	public void getAllUserTestCase () {
		
		int actualSize= userDAO.list().size();
		
		assertEquals(4,actualSize);
		
	}*/
	
	
	
	
	
	
	
	
}
