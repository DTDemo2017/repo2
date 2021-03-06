package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.SupplierDAO;

import com.niit.shoppingcartbackend.domain.Supplier;



@SuppressWarnings("deprecation")
public class SupplierDAOTestCase {
@Autowired static AnnotationConfigApplicationContext context;
    
	@Autowired static SupplierDAO supplierDAO;
	
	@Autowired static Supplier supplier;
	
	//above objects need to initialize
	@BeforeClass
	public static void initialize()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		
		
		supplier=(Supplier)context.getBean("supplier");
	}
	
	/*@Test
	public void createSupplierTestCase () {
		
		
		supplier.setSupplierid("82");
		supplier.setSuppliername("Lava International Limited.");
		supplier.setSupplieraddress("Bangalore");
		
		boolean flag= supplierDAO.save(supplier);
		System.out.println(" ");
		
		assertEquals("createSupplierTestCase",true,flag);
	}*/
	
	/*@Test
	public void updateSupplierTestCase () {
		
		
		supplier.setSupplierid("82");
		supplier.setSuppliername("Lava International Ltd.");
		supplier.setSupplieraddress("Bangalore");
		
		boolean flag= supplierDAO.update(supplier);
		System.out.println(" ");
		
		assertEquals("createSupplierTestCase",true,flag);
	}*/
	
	/*@Test
	public void validateSupplierTestCase () {
		
		boolean flag=supplierDAO.validate("80", "BigC");
		
		assertEquals(true,flag);
		
	}*/
	
	/*@Test
	public void getAllSupplierTestCase () {
		
		int actualSize= supplierDAO.list().size();
		
		assertEquals(22,actualSize);
		
	}*/
	
	
}
