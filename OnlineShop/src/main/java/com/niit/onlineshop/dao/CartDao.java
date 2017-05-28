package com.niit.onlineshop.dao;



import java.util.List;

import com.niit.onlineshop.model.Cart;
import com.niit.onlineshop.model.CartItem;

public interface CartDao {
	public boolean saveOrUpdate(Cart cart);
	
	public boolean delete(Cart cart);
	
	public Cart showCart(String userId);
	
	public boolean update(Cart cart);

	public List<CartItem> getCartItemsByCartId(int cart);
	
	

}
