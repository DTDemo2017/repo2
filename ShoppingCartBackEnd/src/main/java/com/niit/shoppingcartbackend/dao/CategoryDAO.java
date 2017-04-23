package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.domain.Category;
import com.niit.shoppingcartbackend.domain.User;

public interface CategoryDAO {
	//1)create/register -save
		public boolean save(Category category);
		
		//2)update the category details -update
		public boolean update(Category category);
		
		//3)validate the credentials -validate
		public boolean validate(String id, String name);
		
		//4)get all users-list
		public List<Category> list();
		
		//5)get user details based on userID
		public Category get(String id);

}
