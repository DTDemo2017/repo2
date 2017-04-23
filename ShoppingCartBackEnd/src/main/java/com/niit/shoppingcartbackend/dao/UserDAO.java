package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.domain.User;

public interface UserDAO {
	//declare the methods
	//what type of operations we are going to do for user
	//Operations
	
	//1)create/register -save
	public boolean save(User user);
	
	//2)update the user details -update
	public boolean update(User user);
	
	//3)validate the credentials -validate
	public boolean validate(String id, String password);
	
	//4)get all users-list
	public List<User> list();
	
	//5)get user details based on userID
	public User get(String id);

}
