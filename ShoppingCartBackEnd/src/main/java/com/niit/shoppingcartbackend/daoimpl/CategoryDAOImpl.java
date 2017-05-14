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
	
	public boolean delete(String categoryid) {
		try{
			getCurrentSession().delete(getCategoryByCategoryID(categoryid));
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
		
	}

	public boolean validate(String categoryid, String categoryname) {
		Query query= sessionFactory.getCurrentSession().createQuery("from Category where categoryid= ? and categoryname= ?");
		query.setString(0,  categoryid);
		query.setString(1,  categoryname);
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

	

	public Category getCategoryByCategoryID(String categoryid) {
		return(Category)getCurrentSession().get(Category.class, categoryid);
		//select * from category where categoryid= ?
	}

	public Category getCategoryByCategoryName(String categoryname) {
		return(Category)getCurrentSession().createQuery("from Category where categoryname= ?")
				.setString(0, categoryname).uniqueResult();
		
		
	}

	

}
