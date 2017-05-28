package com.letzchat.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.letzchat.collaboration.model.Users;

@Repository("usersDAO")
public class UsersDAO {
public UsersDAO(){}
	
	@Autowired
	SessionFactory sessionFactory;
	
	public UsersDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		System.out.println("Constructor of Users");
	}
	
	@Transactional
	public void insertUsers(com.letzchat.collaboration.model.Users users)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(users);
	}

	@Transactional
	public List <Users> getAllUsers()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Users");
		List<Users> users= query.list();
		session.close();
		
		return users;
		
	}
	
	@Transactional
	public void deleteUsers(int userid)
	{
		Users users=(Users)sessionFactory.getCurrentSession().get(Users.class, userid);
		sessionFactory.getCurrentSession().delete(users);
	}
	
	@Transactional
	public Users getUsers(int userid)
	{
		Session session=sessionFactory.openSession();
		Users users=(Users)session.get(Users.class,  userid);
		session.close();
		return users;
	}


}
