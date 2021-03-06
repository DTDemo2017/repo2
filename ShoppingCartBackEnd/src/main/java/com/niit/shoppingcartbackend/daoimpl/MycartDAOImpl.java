package com.niit.shoppingcartbackend.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.shoppingcartbackend.dao.MycartDAO;
import com.niit.shoppingcartbackend.domain.Mycart;


@Repository("mycartDAO")
@Transactional
public class MycartDAOImpl implements MycartDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public MycartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
//written user defined constructor with one parameter i.e. sessionFactory
	
    public MycartDAOImpl(){}
	public boolean save(Mycart mycart) {
		try{
			sessionFactory.getCurrentSession().save(mycart);
		}
		catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Mycart mycart) {
		try{
			sessionFactory.getCurrentSession().update(mycart);
		}
		catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean validate(int mycartid, String userid) {
		Query query= sessionFactory.getCurrentSession().createQuery("from Mycart where mycartid= ? and userid= ?");
		query.setInteger(0,  mycartid);
		query.setString(1,  userid);
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

	public List<Mycart> list() {
		return	sessionFactory.getCurrentSession().createQuery("from Mycart").list();
	}

	public Mycart get(int mycartid) {
		return (Mycart)sessionFactory.getCurrentSession().get(Mycart.class, mycartid);
	}

	public List<Mycart> list(String userID) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Mycart where userID=?");
		query.setString(0, userID);
		return query.list();
	}
	
	
	public double getTotalAmount(String userID) {
		Query query = sessionFactory.getCurrentSession().createQuery("select sum(price) from Mycart where userID=?");
		
		return (Double)query.uniqueResult();
	}

	public void saveMycart(Mycart m) {
Session s= sessionFactory.openSession();
		
		try{
			s.beginTransaction();
			m= new Mycart();
			m.setMycartid(1);
			m.setUserid("Avantika");
			m.setProductname("Headphones");
			m.setPrice("Sixhundred fifty");
			m.setStatus('N');
			m.setQuantity('1');
			m.setDateadded(null);
			
			s.save(m);
			s.getTransaction().commit();
			System.out.println("record inserted.....");
		}
		catch(Exception ex)
		{
			if((s.getTransaction()) !=null)
			{s.getTransaction().rollback();
			}
			System.out.println("exception occured .....:+ex");
			
		}
		
	}

	

}
