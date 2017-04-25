package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.ProductDAO;
import com.niit.shoppingcartbackend.domain.Product;





@SuppressWarnings("deprecation")
public class ProductDAOTestCase {
@Autowired static AnnotationConfigApplicationContext context;
    
	@Autowired static ProductDAO productDAO;
	
	@Autowired static Product product;
	
	//above objects need to initialize
	@BeforeClass
	public static void initialize()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
		
		
		product=(Product)context.getBean("product");
    }
	
	@Test
	public void createProductTestCase () {
		
		
		product.setId("14");
		product.setName("Refrigerator");
		product.setDescription("This is refrigerator .");
		product.setPrice("80000");
		product.setCategory_id("03");
		product.setSupplier_id("80");
		boolean flag= productDAO.save(product);
		System.out.println(" ");
		
		assertEquals("createProductTestCase",true,flag);
		
	}
	
	@Test
	public void updateProductTestCase () {
		
		
		product.setId("14");
		product.setName("Refrigerator");
		product.setDescription("This is refrigerator product.");
		product.setPrice("80000");
		product.setCategory_id("03");
		product.setSupplier_id("80");
		boolean flag= productDAO.update(product);
		System.out.println(" ");
		
		assertEquals("updateProductTestCase",true,flag);
		
	}
	
	@Test
	public void validateProductTestCase () {
		
		boolean flag=productDAO.validate("12", "Mobile");
		
		assertEquals(true,flag);
		
	}	
	
	@Test
	public void getAllProductTestCase () {
		
		int actualSize= productDAO.list().size();
		
		assertEquals(3,actualSize);
		
	}	
	
	
	
	
	

	

}
