package com.niit.shoppingcartbackend.daoimpl;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.dao.CategoryDAO;
import com.niit.shoppingcartbackend.domain.Category;
import com.niit.shoppingcartbackend.domain.User;
@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//written user defined constructor with one parameter i.e. sessionFactory
	
	CategoryDAOImpl(){}
	
	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}

	
	
	

	public boolean save(Category category) {
		try{
			getCurrentSession().save(category);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Category category) {
		try{
			getCurrentSession().update(category);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean delete(String id) {
		try{
			getCurrentSession().delete(getCategoryByID(id));
		}
		catch(Exception ex){
			ex.printStackTrace();
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
		return getCurrentSession().createQuery("from Category").list();
	}

	

	public Category getCategoryByID(String id) {
		return(Category)getCurrentSession().get(Category.class, id);
		//select * from category where id= ?
	}

	public Category getCategoryByName(String name) {
		return(Category)getCurrentSession().createQuery("from Category where name= ?")
				.setString(0, name).uniqueResult();
		
		
	}

}
