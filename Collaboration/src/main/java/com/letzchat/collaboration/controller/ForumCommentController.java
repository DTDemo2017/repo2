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

import com.letzchat.collaboration.dao.ForumCommentDAO;
import com.letzchat.collaboration.model.ForumComment;

@RestController
public class ForumCommentController {
	@Autowired ForumCommentDAO forumcommentDAO;
	@RequestMapping(value="/getForumComments", method= RequestMethod.GET)
	
	public ResponseEntity<List<ForumComment>> getAllForumComments()
	{
		List<ForumComment> listforumcomments=forumcommentDAO.getAllForumComments();
		return new ResponseEntity<List<ForumComment>>(listforumcomments,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/insertForumComment", method=RequestMethod.POST)
	public ResponseEntity<String> insertForumComment(@RequestBody ForumComment forumcomment)
	{
		forumcomment.setCommentdate(new Date());
		forumcomment.setComments("I like to discuss at AssembleHere.com");
		forumcomment.setUsername("Ashmita Kumari");
		forumcomment.setUserid(1004);
		forumcommentDAO.insertForumComment(forumcomment);
		return new ResponseEntity<String>("Successfully Inserted", HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/deleteForumComment/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteForumComment(@PathVariable("id") int id)
	{
		forumcommentDAO.deleteForumComment(id);
		return new ResponseEntity<String>("Deleted ForumComment Successfully",HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/updateForumComment/{id}", method=RequestMethod.PUT)
	public ResponseEntity<ForumComment> updateForumComment(@PathVariable("id") int id,@RequestBody ForumComment forumcomment)
	{
		ForumComment curr_forumcomment=forumcommentDAO.getForumComment(id);
		curr_forumcomment.setComments(forumcomment.getComments());
		forumcommentDAO.insertForumComment(curr_forumcomment);
		return new ResponseEntity<ForumComment>(curr_forumcomment,HttpStatus.OK);
		
	}

}
