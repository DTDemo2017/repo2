package com.niit.onlineshop.dao;

import java.util.List;

import com.niit.onlineshop.model.Category;




public interface CategoryDao {

	public List<Category> list();
	public Category get(int categoryid);
	public void addCategory(Category category);
	public List<Category> getAllCategories();
	public Category listByCategoryId(int categoryId);
	public void updateCategory(Category category);
	
	
}
