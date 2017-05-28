package com.letzchat.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.letzchat.collaboration.model.ForumComment;

@Repository("forumcommentDAO")
public class ForumCommentDAO {
public ForumCommentDAO(){}
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ForumCommentDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		System.out.println("Constructor of ForumComment");
	}
	
	@Transactional
	public void insertForumComment(com.letzchat.collaboration.model.ForumComment forumcomment)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(forumcomment);
	}

	@Transactional
	public List <ForumComment> getAllForumComments()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from ForumComment");
		List<ForumComment> forumcomments= query.list();
		session.close();
		
		return forumcomments;
		
	}
	
	@Transactional
	public void deleteForumComment(int id)
	{
		ForumComment forumcomment=(ForumComment)sessionFactory.getCurrentSession().get(ForumComment.class, id);
		sessionFactory.getCurrentSession().delete(forumcomment);
	}
	
	
	@Transactional
	public ForumComment getForumComment(int id)
	{
		Session session=sessionFactory.openSession();
		ForumComment forumcomment=(ForumComment)session.get(ForumComment.class,  id);
		session.close();
		return forumcomment;
	}

	

}
