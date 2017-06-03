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

import com.letzchat.collaboration.dao.ForumDAO;
import com.letzchat.collaboration.dao.ForumDAO;
import com.letzchat.collaboration.model.Forum;
import com.letzchat.collaboration.model.Forum;

@RestController
public class ForumController {
	@Autowired ForumDAO forumDAO;
	@RequestMapping(value="/getForums", method= RequestMethod.GET)
	
	public ResponseEntity<List<Forum>> getAllForums()
	{
		List<Forum> listforums=forumDAO.getAllForums();
		return new ResponseEntity<List<Forum>>(listforums,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/insertForum", method=RequestMethod.POST)
	public ResponseEntity<String> insertForum(@RequestBody Forum forum)
	{
		forum.setCreatedate(new Date());
		forum.setStatus("NA");
		forum.setUserid(1004);//Ashmita Kumari
		forumDAO.insertForum(forum);
		return new ResponseEntity<String>("Successfully Inserted", HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/deleteForum/{forumid}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteForum(@PathVariable("forumid") int forumid)
	{
		forumDAO.deleteForum(forumid);
		return new ResponseEntity<String>("Deleted Forum Successfully",HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/updateForum/{forumid}", method=RequestMethod.PUT)
	public ResponseEntity<Forum> updateForum(@PathVariable("forumid") int forumid,@RequestBody Forum forum)
	{
		Forum curr_forum=forumDAO.getForum(forumid);
		curr_forum.setStatus(forum.getStatus());
		forumDAO.insertForum(curr_forum);
		return new ResponseEntity<Forum>(curr_forum,HttpStatus.OK);
		
	}

}
