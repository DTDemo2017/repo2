package com.letzchat.collaboration;



import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.letzchat.collaboration.dao.BlogDAO;
import com.letzchat.collaboration.model.Blog;

public class BlogTestCase {

	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.letzchat.collaboration");
		context.refresh();
		
		BlogDAO blogDAO=(BlogDAO)context.getBean("blogDAO");
		
       /* Blog blog= new Blog();
		
		blog.setBlogid(1001);
		blog.setBlogname("Enumeration");
		blog.setBlogcontent("Enumeration has added in jdk 1.5 version.");
		blog.setCreatedate(new Date());
		blog.setUserid(1003);
		blog.setLikes(3);
		blog.setStatus("NA");
		
		blogDAO.insertBlog(blog);
		System.out.println("Blog Details Added");*/
		
		Blog blog= new Blog();
		
		blog.setBlogid(1002);
		blog.setBlogname("Adv Java");
		blog.setBlogcontent("Servlet is one of the component");
		blog.setCreatedate(new Date());
		blog.setUserid(1003);
		blog.setLikes(3);
		blog.setStatus("NA");
		
		blogDAO.insertBlog(blog);
		System.out.println("Blog Details Added");
		
		//Retrieve the blogs
		/*List<Blog> blogs= blogDAO.getAllBlogs();
		for (Blog b: blogs)
		{
			System.out.println(b.getBlogid()+ ":");
			System.out.println(b.getBlogname()+ ":");
			System.out.println(b.getBlogcontent()+ ":");
			System.out.println(b.getUserid()+ ":");
			System.out.println(b.getStatus()+ ":");
			System.out.println(b.getLikes()+ ":");
			System.out.println(b.getCreatedate()+ ":");
		}*/
		
		//Deleting a Blog
		/*blogDAO.deleteBlog(1001);
		System.out.println("Blog Deleted");*/
		
		
		//Change value of a column in Blog
		/*Blog blog=blogDAO.getBlog(1002);
		blog.setStatus("APPROVE");
		blogDAO.insertBlog(blog);
		System.out.println("Blog Updated");*/
		
		
		

	}

}
