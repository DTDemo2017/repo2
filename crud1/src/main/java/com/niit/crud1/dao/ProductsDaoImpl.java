package com.niit.crud1.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.BeanCreationException;

import com.niit.crud1.dao.ProductsDao;

import com.niit.crud1.model.Products;

@Repository("productsDao")
@Transactional
public class ProductsDaoImpl implements ProductsDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	public void addProducts(Products products) {
		// TODO Auto-generated method stub

		Session session = getSession();

	//	String s = products.getProductName();

		session.save(products);

		session.flush();

		session.close();

	}

	public Products getProductsById(int productId) {
		// TODO Auto-generated method stub
		Session session = getSession();
		return (Products) session.get(Products.class, productId);
	}

	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Products");
		List<Products> productList = query.list();

		return productList;

	}

	public Products getProductsByProductname(String productName) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Products where productname = ?");
		query.setString(0, productName);

		return (Products) query.uniqueResult();

	}

	public void updateProducts(Products products) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String s = products.getProductName();

		session.update(products);

		session.flush();

		session.close();
	}



	public void deleteProducts(int productId) {
		// TODO Auto-generated method stub
		
		Session session = getSession();

		Query query = session.createQuery("from Products where productId = ?");
		query.setInteger(0, productId);

		Products p=(Products) query.uniqueResult();
		session.delete(p);
		session.flush();

		session.close();

	}

}
