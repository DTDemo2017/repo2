package com.niit.shoppingcartbackend.config;



import javax.sql.DataSource;

import org.hibernate.SessionFactory;

import com.niit.shoppingcartbackend.daoimpl.MycartDAOImpl;
import com.niit.shoppingcartbackend.domain.Mycart;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContextConfig con= new ApplicationContextConfig();
        DataSource ds= con.getH2DataSource();
        SessionFactory sf= con.getSessionFactory(ds);
        System.out.println("main method ends......");
        
        MycartDAOImpl  m=new MycartDAOImpl();
       
		m.setSessionFactory(sf);
        m.saveMycart(new Mycart());
        
        
    }
}
