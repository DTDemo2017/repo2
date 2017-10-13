package com.niit.collaborationplatform.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationplatform.dao.ForumCommentDAO;
import com.niit.collaborationplatform.model.ForumComment;

@RestController
public class ForumCommentController {
Logger log = Logger.getLogger(ForumCommentController.class);
	
	@Autowired
	ForumCommentDAO forumcommentDAO;
	
	
	
	
	@GetMapping(value = "/forumcomments")
	public ResponseEntity<List<ForumComment>> listForumComments() {
		log.debug("**********Starting of listForumComments() method.");
		List<ForumComment> forumcomment = forumcommentDAO.list();
		if(forumcomment.isEmpty()) {
			return new ResponseEntity<List<ForumComment>>(HttpStatus.NO_CONTENT);
		}
		log.debug("**********End of listForumComments() method.");
		return new ResponseEntity<List<ForumComment>>(forumcomment, HttpStatus.OK);
	}
	
	
	
	
	
		
	

	
	
	@PutMapping(value = "/updateForumComment/{id}")   // in URL we give/updateForumComment/1
	public ResponseEntity<ForumComment> updateForumComment(@PathVariable("id") int id, @RequestBody ForumComment forumcomment) {
		log.debug("**********Starting of updateForumComment() method.");
		
		{
				ForumComment forumcomment1=forumcommentDAO.get(id);
				forumcomment1.setComments(forumcomment.getComments());
				forumcommentDAO.update(forumcomment1);
				log.debug("**********End of updateForumComment() method.");
			return new ResponseEntity<ForumComment>(forumcomment1, HttpStatus.OK);
		}
		
	}
	
	
	
	@DeleteMapping(value = "/deleteForumComment/{id}")
	public ResponseEntity<ForumComment> deleteForumComment(@PathVariable("id") int id) {
		log.debug("**********Starting of deleteForumComment() method.");
		ForumComment forumcomment = forumcommentDAO.get(id);
		if(forumcomment == null) {
			forumcomment = new ForumComment();
			forumcomment.setErrorMessage("No forumcomment exist with id : " + id);
			log.error("No forumcomment exist with id : " + id);
			return new ResponseEntity<ForumComment>(forumcomment, HttpStatus.NOT_FOUND);
		}
		forumcommentDAO.delete(forumcomment);
		log.debug("**********End of deleteForumComment() method.");
		return new ResponseEntity<ForumComment>(HttpStatus.OK);		
	}
	
	
	
	@GetMapping(value = "/getForumComment/{id}")
	public ResponseEntity<ForumComment> getForumComment(@PathVariable("id") int id) {
		log.debug("**********Starting of getForumComment() method.");
		ForumComment forumcomment = forumcommentDAO.get(id);
		if(forumcomment == null) {
			forumcomment = new ForumComment();
			forumcomment.setErrorMessage("No forumcomment exist with id : " + id);
			log.error("No forumcomment exist with id : " + id);
			return new ResponseEntity<ForumComment>(forumcomment, HttpStatus.NOT_FOUND);
		}
		log.debug("**********End of getForumComment() method.");
		return new ResponseEntity<ForumComment>(forumcomment, HttpStatus.OK);
	}
	
	/*@GetMapping(value = "/getForumComment/{forumId}")
	public ResponseEntity<ForumComment> getForumComment1(@PathVariable("forumId") int forumId) {
		log.debug("**********Starting of getForumComment1() method.");
		ForumComment forumcomment = forumcommentDAO.get(forumId);
		if(forumcomment == null) {
			forumcomment = new ForumComment();
			forumcomment.setErrorMessage("No forumcomment exist with forumId : " +forumId);
			log.error("No forumcomment exist with forumId : " + forumId);
			return new ResponseEntity<ForumComment>(forumcomment, HttpStatus.NOT_FOUND);
		}
		log.debug("**********End of getForumComment1() method.");
		return new ResponseEntity<ForumComment>(forumcomment, HttpStatus.OK);
	}*/
	
	/*@GetMapping(value = "/forumComments/{forumId}")
	public ResponseEntity<List<ForumComment>> listForumComments(@PathVariable("forumId") int forumId) {
		log.debug("**********Starting of listForumComments() method.");
		List<ForumComment> forumComment = forumcommentDAO.getComments(forumId);
		if(forumComment.isEmpty()) {
			return new ResponseEntity<List<ForumComment>>(HttpStatus.NO_CONTENT);
		}
		log.debug("**********End of listForumComments() method.");
		return new ResponseEntity<List<ForumComment>>(forumComment, HttpStatus.OK);
	}*/

	

}
