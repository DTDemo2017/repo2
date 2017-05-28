package com.letzchat.collaboration;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.letzchat.collaboration.dao.ForumCommentDAO;
import com.letzchat.collaboration.model.ForumComment;

public class ForumCommentTestCase {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.letzchat.collaboration");
		context.refresh();
		
		ForumCommentDAO forumcommentDAO=(ForumCommentDAO)context.getBean("forumcommentDAO");
		
		/*ForumComment forumcomment= new ForumComment();
		
		forumcomment.setId(1);
		forumcomment.setForumid(1001);
		forumcomment.setUserid(1003);
		forumcomment.setComments("I like DiscussFast.com");
		forumcomment.setUsername("Ashwini");
		forumcomment.setCommentdate(new Date());
		
		
		
		forumcommentDAO.insertForumComment(forumcomment);
		System.out.println("ForumComment Details Added");*/
		
		
       ForumComment forumcomment= new ForumComment();
		
		forumcomment.setId(2);
		forumcomment.setForumid(1002);
		forumcomment.setUserid(1004);
		forumcomment.setComments("I like to discuss at Assembly.com");
		forumcomment.setUsername("Ashmita");
		forumcomment.setCommentdate(new Date());
		
		
		
		forumcommentDAO.insertForumComment(forumcomment);
		System.out.println("ForumComment Details Added");
		//Retrieve the forumcomments
		/*List<ForumComment> forumcomments= forumcommentDAO.getAllForumComments();
		for (ForumComment c2: forumcomments)
		{
			System.out.println(c2.getId()+ ":");
			System.out.println(c2.getForumid()+ ":");
			System.out.println(c2.getUserid()+ ":");
			System.out.println(c2.getComments()+ ":");
			
			System.out.println(c2.getUsername()+ ":");
			
			System.out.println(c2.getCommentdate()+ ":");
		}*/
		
		//Deleting a ForumComment
		/*forumcommentDAO.deleteForumComment(1);
		System.out.println("ForumComment Deleted");*/
		
		
		//change the value of a column in forumcomment
		/*ForumComment forumcomment1=forumcommentDAO.getForumComment(2);
		forumcomment1.setUsername("Ashmita");
		forumcommentDAO.insertForumComment(forumcomment1);
		System.out.println("ForumComment Updated");*/
		
		
		

	

	

		

	}

}
