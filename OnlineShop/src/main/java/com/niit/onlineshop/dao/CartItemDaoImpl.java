package com.niit.onlineshop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlineshop.model.CartItem;



@Repository("cartItemDao")
@Transactional
public class CartItemDaoImpl implements CartItemDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public CartItemDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	public CartItemDaoImpl(){}

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession(){
		return sessionFactory.openSession();
	}
	
	@Transactional
	public boolean saveOrUpdate(CartItem cartItem) {
		try{
			Session session = getSession();
			session.saveOrUpdate(cartItem);
			session.flush();
			session.close();
			
			return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
	}
    @Transactional
	public boolean delete(CartItem cartItem) {
		try{
			Session session = getSession();
			session.delete(cartItem);
			session.flush();
			session.close();
			
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
    
    @Transactional
	public CartItem get(String cartItemId) {
String h = "from CartItem where cartItemId=" + "'" + cartItemId + "'";
		
		Session session = getSession();
		Query q = session.createQuery(h);
		
		
		List<CartItem> list = q.list();
		
		session.flush();
		session.close();
		if(list == null || list.isEmpty())
		{
			
			return null;
		}
		else
		{
			
			return list.get(0);
		}
	}
    @Transactional
	public List<CartItem> getItems(String userId) {
		
		Session session = getSession();
		String h = "from CartItem where cart.user.id=" + "'" + userId + "'";
		Query q = session.createQuery(h);
		return q.list();
	}

	public List<CartItem> getCartItemByCartId(int cartId) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from CartItem where  cart.cartId=?");
		
		query.setInteger(0, cartId);
		List<CartItem> CartItemList = query.list();

		return CartItemList;
	}

	public CartItem get(Integer cartItemId) {
		// TODO Auto-generated method stub
        Session session = getSession();
		
		return (CartItem) session.get(CartItem.class, cartItemId);
	}

	public void deleteItems(int cartItemId) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from CartItem where cartItemId = ?");
		query.setInteger(0, cartItemId);
		CartItem c=(CartItem) query.uniqueResult();
		session.delete(c);
		session.flush();

		session.close();

	}
	

}
