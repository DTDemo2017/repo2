package com.niit.crud1.dao;

import java.util.List;

import com.niit.crud1.model.Products;


public interface ProductsDao {
	
	public void addProducts(Products products);
	public void updateProducts(Products products);
	public void deleteProducts(int productId);
	public Products getProductsById(int productId);

	public List<Products> getAllProducts();

	public Products getProductsByProductname(String productName);
	


}
