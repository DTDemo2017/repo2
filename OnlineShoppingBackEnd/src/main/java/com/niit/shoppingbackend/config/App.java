package com.niit.shoppingbackend.config;



import javax.sql.DataSource;

import org.hibernate.SessionFactory;

import com.niit.shoppingbackend.dao.ProductDaoImpl;
import com.niit.shoppingbackend.model.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContextConfig con= new ApplicationContextConfig();
        DataSource ds= con.getH2Datasource();
        SessionFactory sf= con.getSessionFactory(ds);
        System.out.println("main method ends......");
        
        ProductDaoImpl  p=new ProductDaoImpl();
        p.setSessionFactory(sf);
        p.saveProduct(new Product());
        
        
    }
}
