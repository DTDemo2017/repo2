package com.niit.onlineshop.dao;

import java.util.List;

import com.niit.onlineshop.model.User;

public interface UserDao {
	public void addUsers(User users);

	public User listById(String Id);
	
	public User getUsersById(String Id);
	
	public void editUsers(User users);
	
	//3)validate the credentials -validate
		public boolean validate(String id, String password);
		

}
