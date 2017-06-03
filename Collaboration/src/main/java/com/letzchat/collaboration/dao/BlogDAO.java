package com.letzchat.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.letzchat.collaboration.model.Blog;

@Repository("blogDAO")
public class BlogDAO 
{
	
	public BlogDAO(){}
	
	@Autowired
	SessionFactory sessionFactory;
	
	public BlogDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		System.out.println("Constructor of Blog");
	}
	
	@Transactional
	public void insertBlog(com.letzchat.collaboration.model.Blog blog)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
	}

	@Transactional
	public List <Blog> getAllBlogs()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Blog");
		List<Blog> blogs= query.list();
		session.close();
		
		return blogs;
		
	}
	
	@Transactional
	public void deleteBlog(int blogid)
	{
		Blog blog=(Blog)sessionFactory.getCurrentSession().get(Blog.class, blogid);
		sessionFactory.getCurrentSession().delete(blog);
	}
	
	@Transactional
	public Blog getBlog(int blogid)
	{
		Session session=sessionFactory.openSession();
		Blog blog=(Blog)session.get(Blog.class,  blogid);
		session.close();
		return blog;
	}

	
}
