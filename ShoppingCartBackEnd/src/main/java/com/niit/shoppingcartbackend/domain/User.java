package com.niit.shoppingcartbackend.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.stereotype.Component;

@Entity
@Table(name="User")//if table name and domain class name is different
@Component
public class User {
	public User(){
		
	             }
	@Id
	@Column(name="id")
	private String id;
	@Column(name="name")//if field name in table and property name in class different
	private String name;
	@Min(5)
	@Max(15)
	private String password;//We have defined all properties for all fields in table.
	private String contact;
	private String role;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String toString(){
		return id+ ":" +name+ ":" +password+ ":" +contact+ ":" +role;
	}
	
	

}
