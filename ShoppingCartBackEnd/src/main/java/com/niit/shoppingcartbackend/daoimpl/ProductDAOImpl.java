package com.niit.shoppingcartbackend.daoimpl;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.dao.ProductDAO;
import com.niit.shoppingcartbackend.domain.Product;
@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    //written user defined constructor with one parameter i.e. sessionFactory
	
    ProductDAOImpl(){}
    private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}
    
   /* protected Session getSession() {
		return sessionFactory.openSession();
	}*/
    @Transactional
	public boolean save(Product product) {
		try{
			sessionFactory.getCurrentSession().save(product);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
    @Transactional
	public boolean update(Product product) {
		try{
			sessionFactory.getCurrentSession().update(product);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
    @Transactional
	public boolean validate(String productid, String productname) {
		Query query= sessionFactory.getCurrentSession().createQuery("from Product where productid= ? and productname= ?");
		query.setString(0,  productid);
		query.setString(1,  productname);
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
    @Transactional
	public List<Product> list() {
		return	sessionFactory.getCurrentSession().createQuery("from Product").list();
	}
    @Transactional
	public Product get(String productid) {
		return (Product)sessionFactory.getCurrentSession().get(Product.class, productid);
	}
    @Transactional
	public List<Product> getAllProductsByCategoryID(String categoryid) {
		Query query=	getCurrentSession().createQuery("from Product where categoryID=?");
		query.setString(0, categoryid);
		
	    return	query.list();
	}
    @Transactional
	public List<Product> getSimilarProducts(String search_string) {
		String hql = "from Product where productname like %"+ search_string + "%";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
    @Transactional
	public boolean delete(String productid) {
		try
		{
		getCurrentSession().delete(get(productid));
		}catch (Exception ex) {
			ex.printStackTrace();
		return false;
		}
		
		return true;
	}

	public List<Product> getAllProductsBySupplierID(String supplierid) {
		Query query=	getCurrentSession().createQuery("from Product where supplierID=?");
		query.setString(0, supplierid);
		
	    return	query.list();
	}

	

}
