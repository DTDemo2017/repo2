package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.model.Product;

public interface ProductDao {
	public List<Product> getProductList();
	public void saveProduct(Product p);

}
