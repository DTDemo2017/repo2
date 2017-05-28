package com.niit.onlineshop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlineshop.model.Cart;
import com.niit.onlineshop.model.CartItem;
@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao {
	@Autowired private SessionFactory sessionFactory;
	
	public CartDaoImpl(){}
	
	public CartDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	protected Session getSession()
	{
		return sessionFactory.openSession();
	}
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    
	
	@Transactional
	public boolean saveOrUpdate(Cart cart) {
		try{
			Session session= getSession();
			session.saveOrUpdate(cart);
			session.flush();
			session.close();
			
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
    @Transactional
	public boolean delete(Cart cart) {
		try{
			Session session= getSession();
			session.delete(cart);
			session.flush();
			session.close();
			
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
    @Transactional
	public Cart showCart(String userId) {
		String q="from Cart where user.Id=" + "" + userId + "";
		
		Session session= getSession();
		Query query= session.createQuery(q);
		
		List<Cart> list= query.list();
		
		if(list == null || list.isEmpty())
		{
			session.flush();
			session.close();
			return null;
		}
		else
		{
			session.flush();
			session.close();
			return list.get(0);
		}
	}
    @Transactional
	public boolean update(Cart cart) {
		// TODO Auto-generated method stub
		try{
			Session session= getSession();
			session.update(cart);
			session.flush();
			session.close();
			
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public List<CartItem> getCartItemsByCartId(int cart) {
		Session session = getSession();
		String h = "from CartItem where cart.cartId=" + cart + " and status ='N'";
		Query q = session.createQuery(h);
		return q.list();
	}

}
