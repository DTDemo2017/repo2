package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.domain.Category;
import com.niit.shoppingcartbackend.domain.Product;

public interface ProductDAO {
	//1)create/register -save
		public boolean save(Product product);
		
		//2)update the product details -update
		public boolean update(Product product);
		
		//3)validate the credentials -validate
		public boolean validate(String productid, String productname);
		
		//4)get all products-list
		public List<Product> list();
		
		//5)get product details based on productID
		public Product get(String productid);

		//6)
		public List<Product> getAllProductsByCategoryID(String categoryid);

		//7)
		List<Product> getSimilarProducts(String search_string);

		//8)
		public boolean delete(String productid);
		
		//9)
		public List<Product> getAllProductsBySupplierID(String supplierid);

		

		

}
