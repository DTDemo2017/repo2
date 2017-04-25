package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.domain.Category;
import com.niit.shoppingcartbackend.domain.User;

public interface CategoryDAO {
	//1)create/register -save
		public boolean save(Category category);
		
		//2)update the category details -update
		public boolean update(Category category);
		
		//3)delete
		public boolean delete(String id);
		
		//3)validate the credentials -validate
		public boolean validate(String id, String name);
		
		//4)get all categories-list
		public List<Category> list();
		
		//5)get category details based on ID
		public Category getCategoryByID(String id);
		
		//6)get category details based on name
		public Category getCategoryByName(String name);

}
