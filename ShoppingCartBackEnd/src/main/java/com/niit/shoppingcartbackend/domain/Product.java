package com.niit.shoppingcartbackend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name="product")
@Component
public class Product {
	public Product(){}
	@Id
	@Column(name="productid")
	private String productid;
	
	private String productname;
	private String productdescription;
	private String productprice;

	
	

	private String categoryid;
	private String supplierid;
	
	
	
	@ManyToOne
	@JoinColumn(name="categoryid", updatable=false, insertable=false, nullable=false)
	private Category productcategory;
	
	@ManyToOne
	@JoinColumn(name="supplierid", updatable=false, insertable=false, nullable=false)
	private Supplier productsupplier;
	
	
	@Transient
	private MultipartFile image;
	
	private String productimage;
	
	
	
	
	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	public String getProductprice() {
		return productprice;
	}

	public void setProductprice(String productprice) {
		this.productprice = productprice;
	}
	
	

	
	
	
	

	
	
	
	

	

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	public String getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}

	
	
	public Category getProductcategory() {
		return productcategory;
	}

	public void setProductcategory(Category productcategory) {
		this.productcategory = productcategory;
	}

	public Supplier getProductsupplier() {
		return productsupplier;
	}

	public void setProductsupplier(Supplier productsupplier) {
		this.productsupplier = productsupplier;
	}

	
	
	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	
	
	
	public String getProductimage() {
		return productimage;
	}

	public void setProductimage(String productimage) {
		this.productimage = productimage;
	}

	
	
	
	
	
	
	

}
