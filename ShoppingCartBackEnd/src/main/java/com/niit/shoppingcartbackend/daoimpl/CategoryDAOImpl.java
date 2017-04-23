package com.niit.shoppingcartbackend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.dao.CategoryDAO;
import com.niit.shoppingcartbackend.domain.Category;
import com.niit.shoppingcartbackend.domain.User;
@Repository("CategoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public CategoryDAOImpl(){
		
	                    }
	
	//write user defined constructor with one parameter i.e. sessionFactory
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public boolean save(Category category) {
		try{
			sessionFactory.getCurrentSession().save(category);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Category category) {
		try{
			sessionFactory.getCurrentSession().update(category);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean validate(String id, String name) {
		Query query= sessionFactory.getCurrentSession().createQuery("from Category where id= ? and name= ?");
		query.setString(0,  id);
		query.setString(1,  name);
		query.uniqueResult();
		
		if (query.uniqueResult() ==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public List<Category> list() {
		return	sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public Category get(String id) {
		return (Category)sessionFactory.getCurrentSession().get(Category.class, id);
	}

}
