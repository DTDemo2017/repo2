package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.domain.Product;
import com.niit.shoppingcartbackend.domain.User;

public interface ProductDAO {
	//1)create/register -save
		public boolean save(Product product);
		
		//2)update the product details -update
		public boolean update(Product product);
		
		//3)validate the credentials -validate
		public boolean validate(String id, String name);
		
		//4)get all products-list
		public List<Product> list();
		
		//5)get product details based on userID
		public Product get(String id);

}
