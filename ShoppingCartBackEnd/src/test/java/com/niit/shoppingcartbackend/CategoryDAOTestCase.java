package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.CategoryDAO;

import com.niit.shoppingcartbackend.domain.Category;





@SuppressWarnings("deprecation")
public class CategoryDAOTestCase {

@Autowired static AnnotationConfigApplicationContext context;
    
	@Autowired static CategoryDAO categoryDAO;
	
	@Autowired static Category category;

	
	//above objects need to initialize
	@BeforeClass
	public static void initialize(){
	
	context= new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	
	categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	
	
	category=(Category)context.getBean("category");
	}
	
	/*@Test
	public void createCategoryTestCase () {
		
		
		category.setCategoryid("03");
		category.setCategoryname("Refrigerator");
		category.setCategorydescription("This is refrigerator category.");
		
		boolean flag= categoryDAO.save(category);
		System.out.println(" ");
		
		assertEquals("createCategoryTestCase",true,flag);
		
	}*/
	
	/*@Test
	public void updateCategoryTestCase () {
		
		
		category.setCategoryid("03");
		category.setCategoryname("Refrigerator");
		category.setCategorydescription("This is refrigerator category..");
		
		boolean flag= categoryDAO.update(category);
		System.out.println(" ");
		
		assertEquals("updateCategoryTestCase",true,flag);
		
	}*/
	
	/*@Test
	public void validateCategoryTestCase () {
		
		boolean flag=categoryDAO.validate("01", "LCD TV");
		
		assertEquals(true,flag);
		
	}*/
	
	/*@Test
	public void getAllCategoryTestCase () {
		
		int actualSize= categoryDAO.list().size();
		
		assertEquals(10,actualSize);
		
	}*/
}
	
