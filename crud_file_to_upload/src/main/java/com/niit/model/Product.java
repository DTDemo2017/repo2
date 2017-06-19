package com.niit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
@Entity
@Table(name="product")
@Component
public class Product implements Serializable{
	@Id
	@GeneratedValue
	@Column(name="productid")
	private int productId;
	
	@NotEmpty(message = "Please enter Product Name")
	@Column(name="productname")
	private String productName;
	
	@NotEmpty(message = "Please enter Product Category")
	@Column(name="productcategory")
	private String productCategory;
	
	@NotEmpty(message = "Please enter Price")
	@Column(name="productprice")
	private String productPrice;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	
	public Product()
	{
		
	}
	
	

}
