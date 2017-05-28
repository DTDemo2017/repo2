package com.niit.onlineshop.dao;

import java.util.List;


import com.niit.onlineshop.model.Product;



public interface ProductDao {
	public void addProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProducts(int productId);
	public Product getProductByProductname(String productName);
	public Product getProductByProductId(int productId);
	public List<Product> list();
	public List<Product> listByCategoryId(int categoryId);
	public Product listByProductId(int productId);
	public List<Product> getAllProducts();
	
}
