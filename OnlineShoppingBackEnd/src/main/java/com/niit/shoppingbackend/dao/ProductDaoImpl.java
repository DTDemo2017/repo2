package com.niit.shoppingbackend.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingbackend.model.Product;
@Repository("productDao")
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		return null;
	}
    @Transactional
	public void saveProduct(Product p) {
		// TODO Auto-generated method stub
		
		Session s= sessionFactory.openSession();
		
		try{
			s.beginTransaction();
			p= new Product();
			p.setId(2);
			p.setName("SofaSet");
			p.setDescription("Drawing room furnitures");
			p.setPrice(10000.25);
			s.save(p);
			s.getTransaction().commit();
			System.out.println("record inserted.....");
		}
		catch(Exception ex)
		{
			if((s.getTransaction()) !=null)
			{s.getTransaction().rollback();
			}
			System.out.println("exception occured .....:+ex");
			
		}
		

	}

}
