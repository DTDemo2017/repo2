package com.niit.crud1.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Products implements Serializable{
	@Id
	@GeneratedValue
	@Column(name="productid")
	private int productId;
	@NotEmpty(message = "Please enter Product Name")
	private String productName;
	@NotEmpty(message = "Please enter Price")
	
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
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	
	public Products()
	{
	}
	

}

