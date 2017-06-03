package com.letzchat.collaboration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.letzchat.collaboration.dao.UsersDAO;
import com.letzchat.collaboration.model.Users;

@RestController
public class UserController {
	@Autowired UsersDAO usersDAO;
	@RequestMapping(value="/getUsers", method= RequestMethod.GET)
	
	public ResponseEntity<List<Users>> getAllUsers()
	{
		List<Users> listusers=usersDAO.getAllUsers();
		return new ResponseEntity<List<Users>>(listusers,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/insertUser", method=RequestMethod.POST)
	public ResponseEntity<String> insertUsers(@RequestBody Users users)
	{
		
		
		
		users.setUserid(1005);
		users.setFirstname("Anamika ");
		users.setLastname("Kumari ");
		users.setPassword("anamika ");
		users.setEmailid("anamikakumari@gmail.com ");
		users.setRole("Student ");
		users.setStatus("NA");
		
		usersDAO.insertUsers(users);
		return new ResponseEntity<String>("Successfully Inserted", HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/deleteUser/{userid}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteUsers(@PathVariable("userid") int userid)
	{
		usersDAO.deleteUsers(userid);
		return new ResponseEntity<String>("Deleted Users Successfully",HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/updateUser/{userid}", method=RequestMethod.PUT)
	public ResponseEntity<Users> updateUsers(@PathVariable("userid") int userid,@RequestBody Users users)
	{
		Users curr_users=usersDAO.getUsers(userid);
		curr_users.setStatus(users.getStatus());
		usersDAO.insertUsers(curr_users);
		return new ResponseEntity<Users>(curr_users,HttpStatus.OK);
		
	}

}
