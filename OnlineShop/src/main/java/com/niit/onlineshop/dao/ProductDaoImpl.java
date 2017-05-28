package com.niit.onlineshop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.onlineshop.model.Product;




@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao{
	
	
	
	
		@Autowired
		private SessionFactory sessionFactory;
		
		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		protected Session getSession() {
			return sessionFactory.openSession();
		}
		

    @Transactional
	public List<Product> list() {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Product");
		List<Product> productList = query.list();
        session.close();
		return productList;
	}
	@Transactional
	public List<Product> listByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Product where productCategory.categoryId = :categoryId");
		query.setParameter("categoryId", categoryId);
		List<Product> productList = query.list();
        session.close();
        System.out.println("list "+productList);
		return productList;
	}
	@Transactional
	public Product listByProductId(int productId) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Product where productId = :productId");
		query.setParameter("productId", productId);
		Product product = (Product)query.uniqueResult();
        session.close();
        
		return product;
	}
	@Transactional
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String p = product.getProductName();

		session.save(product);

		session.flush();

		session.close();

	}
	@Transactional
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String p = product.getProductName();

		session.update(product);

		session.flush();

		session.close();
	}
	@Transactional
	public void deleteProducts(int productId) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Product where productId = ?");
		query.setInteger(0, productId);

		Product p=(Product) query.uniqueResult();
		session.delete(p);
		session.flush();

		session.close();
	}
	@Transactional
	public Product getProductByProductname(String productName) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Product where productname = ?");
		query.setString(0, productName);

		return (Product) query.uniqueResult();
	}
	@Transactional
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Product");
		List<Product> productList = query.list();

		return productList;

	}
	public Product getProductByProductId(int productId) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Product where productid = ?");
		query.setInteger(0, productId);

		return (Product) query.uniqueResult();
	}
	
	
	

}
