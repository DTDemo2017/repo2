package com.letzchat.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.letzchat.collaboration.model.BlogComment;

@Repository("blogcommentDAO")
public class BlogCommentDAO {
public BlogCommentDAO(){}
	
	@Autowired
	SessionFactory sessionFactory;
	
	public BlogCommentDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		System.out.println("Constructor of BlogComment");
	}
	
	@Transactional
	public void insertBlogComment(com.letzchat.collaboration.model.BlogComment blogcomment)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(blogcomment);
	}

	/*@Transactional
	public List <BlogComment> getAllBlogComments()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from BlogComment");
		List<BlogComment> blogcomments= query.list();
		session.close();
		
		return blogcomments;
		
	}*/
	
	/*@Transactional
	public void deleteBlogComment(int id)
	{
		BlogComment blogcomment=(BlogComment)sessionFactory.getCurrentSession().get(BlogComment.class, id);
		sessionFactory.getCurrentSession().delete(blogcomment);
	}*/
	
	
	/*@Transactional
	public BlogComment getBlogComment(int id)
	{
		Session session=sessionFactory.openSession();
		BlogComment blogcomment=(BlogComment)session.get(BlogComment.class,  id);
		session.close();
		return blogcomment;
	}*/

	

}
