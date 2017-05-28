package com.letzchat.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.letzchat.collaboration.model.Forum;

@Repository("forumDAO")
public class ForumDAO {
public ForumDAO(){}
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ForumDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		System.out.println("Constructor of Forum");
	}
	
	@Transactional
	public void insertForum(com.letzchat.collaboration.model.Forum forum)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(forum);
	}

	@Transactional
	public List <Forum> getAllForums()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Forum");
		List<Forum> forums= query.list();
		session.close();
		
		return forums;
		
	}
	
	@Transactional
	public void deleteForum(int forumid)
	{
		Forum forum=(Forum)sessionFactory.getCurrentSession().get(Forum.class, forumid);
		sessionFactory.getCurrentSession().delete(forum);
	}
	
	@Transactional
	public Forum getForum(int forumid)
	{
		Session session=sessionFactory.openSession();
		Forum forum=(Forum)session.get(Forum.class,  forumid);
		session.close();
		return forum;
	}


}
