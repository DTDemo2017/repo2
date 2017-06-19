package com.niit.onlineshop.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlineshop.model.Product;
import com.niit.onlineshop.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}
    @Transactional
	public boolean addUsers(User users) {
		// TODO Auto-generated method stub
    	
    	try
    	{
		Session session = getSession();

		String s = users.getName();

		users.setEnabled(true);

		users.setRole("ROLE_USER");
		
		session.save(users);

		session.flush();

		session.close();
		return true;
    	}
    	
    	catch(Exception e)
    	{
    		System.out.println("failed ......");
    		return false;
    	}

	} 
    @Transactional
	public User listById(String Id) {
		Session session = getSession();

		Query query = session.createQuery("from User where Id = :Id");
		query.setParameter("Id", Id);
		User user = (User)query.uniqueResult();
        session.close();
        
		return user;
	}
    @Transactional
	public User getUsersById(String Id) {
		Session session = getSession();

		Query query = session.createQuery("from User where Id = ?");
		query.setString(0, Id);

		return (User) query.uniqueResult();
	}
    @Transactional
	public void editUsers(User users) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String s = users.getName();

		users.setEnabled(true);

		users.setRole("ROLE_USER");
		
		session.saveOrUpdate(users);

		session.flush();

		session.close();
	}

	public boolean validate(String id, String password) {
		Query query= sessionFactory.getCurrentSession().createQuery("from User where id= ? and password= ?");
		query.setString(0,  id);
		query.setString(1,  password);
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

	
	

	
}
