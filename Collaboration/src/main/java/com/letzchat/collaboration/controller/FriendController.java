package com.letzchat.collaboration.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.letzchat.collaboration.dao.FriendDAO;
import com.letzchat.collaboration.model.Friend;

@RestController
public class FriendController {
	
	@Autowired FriendDAO friendDAO;
	@RequestMapping(value="/getFriends", method= RequestMethod.GET)
	
	public ResponseEntity<List<Friend>> getAllFriends()
	{
		List<Friend> listfriends=friendDAO.getAllFriends();
		return new ResponseEntity<List<Friend>>(listfriends,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/insertFriend", method=RequestMethod.POST)
	public ResponseEntity<String> insertFriend(@RequestBody Friend friend)
	{
		friend.setId(3);
		friend.setFriendid(1006);
		friend.setStatus("APPROVE");
		friend.setUserid(1005);
		friendDAO.insertFriend(friend);
		return new ResponseEntity<String>("Successfully Inserted", HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/deleteFriend/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteFriend(@PathVariable("id") int id)
	{
		friendDAO.deleteFriend(id);
		return new ResponseEntity<String>("Deleted Friend Successfully",HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/updateFriend/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Friend> updateFriend(@PathVariable("id") int id,@RequestBody Friend friend)
	{
		Friend curr_friend=friendDAO.getFriend(id);
		curr_friend.setUserid(friend.getUserid());
		friendDAO.insertFriend(curr_friend);
		return new ResponseEntity<Friend>(curr_friend,HttpStatus.OK);
		
	}


}
