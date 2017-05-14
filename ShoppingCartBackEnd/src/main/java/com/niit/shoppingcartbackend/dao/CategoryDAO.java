package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.domain.Category;


public interface CategoryDAO {
	//1)create/register -save
		public boolean save(Category category);
		
		//2)update the category details -update
		public boolean update(Category category);
		
		//3)delete
		public boolean delete(String categoryid);
		
		//3)validate the credentials -validate
		public boolean validate(String categoryid, String categoryname);
		
		//4)get all categories-list
		public List<Category> list();
		
		//5)get category details based on ID
		public Category getCategoryByCategoryID(String categoryid);
		
		//6)get category details based on name
		public Category getCategoryByCategoryName(String categoryname);

		

}
