package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Category;




public interface CategoryDao {

	public List<Category> list();
	public Category get(int cid);
	
	
}
