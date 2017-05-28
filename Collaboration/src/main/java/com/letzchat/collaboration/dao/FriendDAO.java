package com.letzchat.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.letzchat.collaboration.model.Friend;

@Repository("friendDAO")
public class FriendDAO {
public FriendDAO(){}
	
	@Autowired
	SessionFactory sessionFactory;
	
	public FriendDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		System.out.println("Constructor of Friend");
	}
	
	@Transactional
	public void insertFriend(com.letzchat.collaboration.model.Friend friend)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(friend);
	}

	@Transactional
	public List <Friend> getAllFriends()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend");
		List<Friend> friends= query.list();
		session.close();
		
		return friends;
		
	}
	
	@Transactional
	public void deleteFriend(int id)
	{
		Friend friend=(Friend)sessionFactory.getCurrentSession().get(Friend.class, id);
		sessionFactory.getCurrentSession().delete(friend);
	}
	
	
	@Transactional
	public Friend getFriend(int id)
	{
		Session session=sessionFactory.openSession();
		Friend friend=(Friend)session.get(Friend.class,  id);
		session.close();
		return friend;
	}


}
