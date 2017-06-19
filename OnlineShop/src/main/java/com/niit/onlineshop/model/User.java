package com.niit.onlineshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User implements Serializable {

	
	@Id
	private String id;
	@NotEmpty(message = "Please enter User Name")
	private  String name;
	@NotEmpty(message = "Please enter Password")
	@Length(min=5 , max=5)
	private String password;
	@Length(min=5 , max=5)
	private String confirmPassword;
	private String emailId;
	@Length(max=5)
	private String address;
	private String PINcode;
	
	private String role;
	private boolean enabled;
	
	@OneToOne
	@JoinColumn(name="cartId")
	Cart cart;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public   String getName() {
		return name;
	}
	public void setName( String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPINcode() {
		return PINcode;
	}
	public void setPINcode(String pINcode) {
		PINcode = pINcode;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public User()
	{
	}
	// parameterised constructor
	// getter setter
	// validation


}
