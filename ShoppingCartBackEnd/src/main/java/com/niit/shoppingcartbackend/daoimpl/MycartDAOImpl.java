package com.niit.shoppingcartbackend.daoimpl;

import java.util.List;



import org.hibernate.Query;
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
	
    MycartDAOImpl(){}
	public boolean save(Mycart mycart) {
		try{
			sessionFactory.getCurrentSession().save(mycart);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Mycart mycart) {
		try{
			sessionFactory.getCurrentSession().update(mycart);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean validate(String id, String user_id) {
		Query query= sessionFactory.getCurrentSession().createQuery("from Mycart where id= ? and user_id= ?");
		query.setString(0,  id);
		query.setString(1,  user_id);
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

	public Mycart get(String id) {
		return (Mycart)sessionFactory.getCurrentSession().get(Mycart.class, id);
	}

}
