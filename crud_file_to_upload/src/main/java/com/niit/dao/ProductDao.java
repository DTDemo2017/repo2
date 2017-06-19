package com.niit.dao;

import java.util.List;

import com.niit.model.Product;



public interface ProductDao {
	public void addProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(int productId);
	public Product getProductById(int productId);

	public List<Product> getAllProduct();

	public Product getProductByProductname(String productName);
	


}
