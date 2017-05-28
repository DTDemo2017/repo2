package com.letzchat.collaboration;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.letzchat.collaboration.dao.BlogCommentDAO;
import com.letzchat.collaboration.dao.BlogDAO;
import com.letzchat.collaboration.model.Blog;
import com.letzchat.collaboration.model.BlogComment;

public class BlogCommentTestCase {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.letzchat.collaboration");
		context.refresh();
		
		BlogCommentDAO blogcommentDAO=(BlogCommentDAO)context.getBean("blogcommentDAO");
        
		BlogComment blogcomment= new BlogComment();
		
		blogcomment.setId(1);
		blogcomment.setBlogid(1001);
		blogcomment.setUserid(1003);
		blogcomment.setComments("I like jdk 1.5 Enumeration");
		blogcomment.setUsername("Ashwini");
		blogcomment.setCommentdate(new Date());
		
		
		
		blogcommentDAO.insertBlogComment(blogcomment);
		System.out.println("BlogComment Details Added");
		
		/*BlogComment blogcomment= new BlogComment();
		
		blogcomment.setId(2);
		blogcomment.setBlogid(1002);
		blogcomment.setUserid(1003);
		blogcomment.setComments("I like Adv Java");
		blogcomment.setUsername("Ashwini");
		blogcomment.setCommentdate(new Date());
		
		
		
		blogcommentDAO.insertBlogComment(blogcomment);
		System.out.println("BlogComment Details Added");*/
		
		//Retrieve the blogs
		/*List<BlogComment> blogcomments= blogcommentDAO.getAllBlogComments();
		for (BlogComment c1: blogcomments)
		{
			System.out.println(c1.getId()+ ":");
			System.out.println(c1.getBlogid()+ ":");
			System.out.println(c1.getUserid()+ ":");
			System.out.println(c1.getComment()+ ":");
			
			System.out.println(c1.getUsername()+ ":");
			
			System.out.println(c1.getCommentdate()+ ":");
		}*/
		
		//Deleting a Blog
		/*blogcommentDAO.deleteBlogComment(2);
		System.out.println("BlogComment Deleted");*/
		
		
		//change the value of a column in a blog
		/*BlogComment blogcomment1=blogcommentDAO.getBlogComment(2);
		blogcomment1.setComment("I like this blog very much.");
		blogcommentDAO.insertBlogComment(blogcomment1);
		System.out.println("BlogComment Updated");*/
		
		
		

	

	}

}
