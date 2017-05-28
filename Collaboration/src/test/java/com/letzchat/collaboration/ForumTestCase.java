package com.letzchat.collaboration;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.letzchat.collaboration.dao.ForumDAO;
import com.letzchat.collaboration.model.Forum;

public class ForumTestCase {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.letzchat.collaboration");
		context.refresh();
		
		ForumDAO forumDAO=(ForumDAO)context.getBean("forumDAO");
		
        /*Forum forum= new Forum();
		
		forum.setForumid(1001);
		forum.setUserid(1003);
		forum.setForumname("DiscussFast");
		forum.setStatus("NA");
		forum.setCreatedate(new Date());
		
		
		
		forumDAO.insertForum(forum);
		System.out.println("Forum Details Added");*/
		
		Forum forum= new Forum();
		
		forum.setForumid(1002);
		forum.setUserid(1004);
		forum.setForumname("Assembly");
		forum.setStatus("NA");
		forum.setCreatedate(new Date());
		
		forumDAO.insertForum(forum);
		System.out.println("Forum Details Added");
		
		//Retrieve the forums
		/*List<Forum> forums= forumDAO.getAllForums();
		for (Forum f: forums)
		{
			System.out.println(f.getForumid()+ ":");
			System.out.println(f.getUserid()+ ":");
			System.out.println(f.getForumname()+ ":");
			
			System.out.println(f.getStatus()+ ":");
			
			System.out.println(f.getCreatedate()+ ":");
		}*/
		
		//Deleting a Forum
		/*forumDAO.deleteForum(1);
		System.out.println("Forum Deleted");*/
		
		
		//Change value of a column in Forum
		Forum forum1=forumDAO.getForum(1);
		forum1.setForumid(1001);
		forumDAO.insertForum(forum1);
		System.out.println("Forum Updated");
		
		
		

	


	}

}
