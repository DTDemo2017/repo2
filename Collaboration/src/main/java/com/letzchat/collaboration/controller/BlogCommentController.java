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

import com.letzchat.collaboration.dao.BlogCommentDAO;
import com.letzchat.collaboration.model.BlogComment;

@RestController
public class BlogCommentController {
	@Autowired BlogCommentDAO blogcommentDAO;
	@RequestMapping(value="/getBlogComments", method= RequestMethod.GET)
	
	public ResponseEntity<List<BlogComment>> getAllBlogComments()
	{
		List<BlogComment> listblogcomments=blogcommentDAO.getAllBlogComments();
		return new ResponseEntity<List<BlogComment>>(listblogcomments,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/insertBlogComment", method=RequestMethod.POST)
	public ResponseEntity<String> insertBlogComment(@RequestBody BlogComment blogcomment)
	{
		blogcomment.setCommentdate(new Date());
		blogcomment.setComments("I like doing Core Java..");
		blogcomment.setUsername("Ashmita Kumari");
		blogcomment.setUserid(1004);
		blogcommentDAO.insertBlogComment(blogcomment);
		return new ResponseEntity<String>("Successfully Inserted", HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/deleteBlogComment/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteBlogComment(@PathVariable("id") int id)
	{
		blogcommentDAO.deleteBlogComment(id);
		return new ResponseEntity<String>("Deleted BlogComment Successfully",HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/updateBlogComment/{id}", method=RequestMethod.PUT)
	public ResponseEntity<BlogComment> updateBlogComment(@PathVariable("id") int id,@RequestBody BlogComment blogcomment)
	{
		BlogComment curr_blogcomment=blogcommentDAO.getBlogComment(id);
		curr_blogcomment.setComments(blogcomment.getComments());
		blogcommentDAO.insertBlogComment(curr_blogcomment);
		return new ResponseEntity<BlogComment>(curr_blogcomment,HttpStatus.OK);
		
	}

}
