package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Product;
@Repository("productDao")
@Transactional
@Component
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = getSession();
		
		session.save(product);

		session.flush();

		session.close();

	}

	

	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String s = product.getProductName();

		session.update(product);

		session.flush();

		session.close();
	}

	

	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Product where productId = ?");
		query.setInteger(0, productId);

		Product p=(Product) query.uniqueResult();
		session.delete(p);
		session.flush();

		session.close();

	}

	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		Session session = getSession();
		return (Product) session.get(Product.class, productId);
	}

	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Product");
		List<Product> productList = query.list();

		return productList;
	}

	public Product getProductByProductname(String productName) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Product where productname = ?");
		query.setString(0, productName);

		return (Product) query.uniqueResult();
	}

}
