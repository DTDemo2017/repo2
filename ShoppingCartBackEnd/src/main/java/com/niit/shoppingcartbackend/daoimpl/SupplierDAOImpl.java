package com.niit.shoppingcartbackend.daoimpl;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.dao.SupplierDAO;
import com.niit.shoppingcartbackend.domain.Category;
import com.niit.shoppingcartbackend.domain.Supplier;
@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    //written user defined constructor with one parameter i.e. sessionFactory
	
	SupplierDAOImpl(){}
	
	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	public boolean save(Supplier supplier) {
		try{
			sessionFactory.getCurrentSession().save(supplier);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Supplier supplier) {
		try{
			sessionFactory.getCurrentSession().update(supplier);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean validate(String supplierid, String suppliername) {
		Query query= sessionFactory.getCurrentSession().createQuery("from Supplier where supplierid= ? and suppliername= ?");
		query.setString(0,  supplierid);
		query.setString(1,  suppliername);
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

	public List<Supplier> list() {
		return	sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	public Supplier get(String supplierid) {
		return (Supplier)sessionFactory.getCurrentSession().get(Supplier.class, supplierid);
	}

	public Supplier getSupplierBySupplierName(String suppliername) {
		return(Supplier)getCurrentSession().createQuery("from Supplier where suppliername= ?")
				.setString(0, suppliername).uniqueResult();
		
	}

	public Supplier getSupplierBySupplierID(String supplierid) {
		return(Supplier)getCurrentSession().get(Supplier.class, supplierid);
		//select * from supplier where supplierid= ?
	}

	public boolean delete(String supplierid) {
		try{
			getCurrentSession().delete(getSupplierBySupplierID(supplierid));
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}

}
