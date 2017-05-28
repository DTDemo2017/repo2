package com.niit.onlineshop.dao;

import java.util.List;

import com.niit.onlineshop.model.CartItem;

public interface CartItemDao {
public boolean saveOrUpdate(CartItem cartItem);
	
	public boolean delete(CartItem cartItem);
	
	public CartItem get(Integer cartItemId);
	
	public List<CartItem> getItems(String userId);

	public List<com.niit.onlineshop.model.CartItem> getCartItemByCartId(int cartId);

	public void deleteItems(int cartItemId);

}
