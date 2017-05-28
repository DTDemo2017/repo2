package com.niit.shoppingcartbackend.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="category")
@Component
public class Category {
	public Category(){
		
	                 }
	@Id
	@Column(name="categoryid")
	private String categoryid;
	
	@Column(name="categoryname")
	private String categoryname;
	
	@Column(name="categorydescription")
	private String categorydescription;
	
	@OneToMany(mappedBy="category", fetch=FetchType.EAGER)
	List<Product> products;
	
	

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getCategorydescription() {
		return categorydescription;
	}

	public void setCategorydescription(String categorydescription) {
		this.categorydescription = categorydescription;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	

	
	
	
	
	

}
