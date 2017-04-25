package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.MycartDAO;
import com.niit.shoppingcartbackend.domain.Mycart;




@SuppressWarnings("deprecation")
public class MycartDAOTestCase {
@Autowired static AnnotationConfigApplicationContext context;
    
	@Autowired static MycartDAO mycartDAO;
	
	@Autowired static Mycart mycart;
	
	//above objects need to initialize
	@BeforeClass
	public static void initialize()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		mycartDAO=(MycartDAO)context.getBean("mycartDAO");
		
		
		mycart=(Mycart)context.getBean("mycart");
    }
	
	@Test
	public void createMycartTestCase () {
		
		
		mycart.setId("102");
		mycart.setUser_id("simran");
		mycart.setProduct_name("Mobile phone");
		mycart.setPrice("12000");
		mycart.setStatus('O');
		mycart.setQuantity("1");
		
		boolean flag= mycartDAO.save(mycart);
		System.out.println(" ");
		
		assertEquals("createMycartTestCase",true,flag);
	}
	
	@Test
	public void updateUserTestCase () {
		
		
		mycart.setId("102");
		mycart.setUser_id("simran");
		mycart.setProduct_name("Mobile");
		mycart.setPrice("12000");
		mycart.setStatus('O');
		mycart.setQuantity("1");
		
		boolean flag= mycartDAO.update(mycart);
		System.out.println(" ");
		
		assertEquals("updateMycartTestCase",true,flag);
		
	}	
	
	@Test
	public void validateMycartTestCase () {
		
		boolean flag=mycartDAO.validate("101", "kiran");
		
		assertEquals(true,flag);
		
	}	
	
	@Test
	public void getAllMycartTestCase () {
		
		int actualSize= mycartDAO.list().size();
		
		assertEquals(2,actualSize);
		
	}	
	
	
}
