package com.letzchat.collaboration;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.letzchat.collaboration.dao.FriendDAO;
import com.letzchat.collaboration.model.Friend;

public class FriendTestCase {

	public static void main(String[] args) {
		
			AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
			context.scan("com.letzchat.collaboration");
			context.refresh();
			
			FriendDAO friendDAO=(FriendDAO)context.getBean("friendDAO");
			
			Friend friend= new Friend();
			
			friend.setId(1);
			
			friend.setUserid(1003);
			friend.setFriendid(1004);
			friend.setStatus("APPROVE");
			
			
			
			
			friendDAO.insertFriend(friend);
			System.out.println("Friend Details Added");
			
           /* Friend friend= new Friend();
			
			friend.setId(2);
			
			friend.setUserid(1004);
			friend.setFriendid(1003);
			friend.setStatus("APPROVE");
			
			
			
			
			friendDAO.insertFriend(friend);
			System.out.println("Friend Details Added");*/
			
			//Retrieve the friends
			/*List<Friend> friends= friendDAO.getAllFriends();
			for (Friend f: friends)
			{
				System.out.println(f.getId()+ ":");
				
				System.out.println(f.getUserid()+ ":");
				System.out.println(f.getFriendid()+ ":");
				System.out.println(f.getStatus()+ ":");
				
				
			}*/
			
			//Deleting a Friend
			/*friendDAO.deleteFriend(1);
			System.out.println("Friend Deleted");*/
			
			
			//change the value of a column in  Friend
			/*Friend friend1=friendDAO.getFriend(2);
			friend1.setStatus("APPROVE");
			friendDAO.insertFriend(friend1);
			System.out.println("Friend Updated");*/
			
			
			

		

		

	}

}
