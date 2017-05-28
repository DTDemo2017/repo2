package com.niit.onlineshop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlineshop.model.Category;





@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	protected Session getSession() {
		return sessionFactory.openSession();
	}
	@Transactional
	public List<Category> list() {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Category");
		List<Category> categoryList = query.list();
        session.close();
		return categoryList;
	}
	@Transactional
	public Category get(int categoryid) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Category where categoryId = :cId");
		query.setParameter("categoryId", categoryid);
		Category category = (Category)query.uniqueResult();
        session.close();
        
		return category;
	}
	@Transactional
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String c = category.getCategoryName();

		session.save(category);

		session.flush();

		session.close();
		
	}
	@Transactional
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Category");
		List<Category> categoryList = query.list();

		return categoryList;

	}
	@Transactional
	public Category listByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Category where categoryId = :categoryId");
		query.setParameter("categoryId", categoryId);
		Category category = (Category)query.uniqueResult();
        session.close();
        
		return category;
	}
	@Transactional
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String c = category.getCategoryName();

		session.update(category);

		session.flush();

		session.close();
	}

}
