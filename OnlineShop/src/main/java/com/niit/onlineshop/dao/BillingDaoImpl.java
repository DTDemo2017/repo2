package com.niit.onlineshop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlineshop.model.Billing;


@Repository("billingDao")
@Transactional
public class BillingDaoImpl implements BillingDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.openSession();
	}

	public void addBilling(Billing billing) {
		// TODO Auto-generated method stub
        Session session=getSession();
		
		session.save(billing);
		session.flush();
		session.close();

	}

}
