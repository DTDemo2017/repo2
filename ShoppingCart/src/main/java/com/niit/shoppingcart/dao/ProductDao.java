package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Product;




public interface ProductDao {
	public List<Product> list();
	public List<Product> listByCategoryId(int categoryId);
	public Product listByProductId(int productId);
	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
}
