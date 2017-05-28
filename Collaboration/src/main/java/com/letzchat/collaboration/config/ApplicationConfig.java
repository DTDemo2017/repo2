package com.letzchat.collaboration.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.letzchat.collaboration.dao.BlogCommentDAO;
import com.letzchat.collaboration.dao.BlogDAO;
import com.letzchat.collaboration.dao.ForumCommentDAO;
import com.letzchat.collaboration.dao.ForumDAO;
import com.letzchat.collaboration.dao.FriendDAO;
import com.letzchat.collaboration.dao.JobDAO;
import com.letzchat.collaboration.dao.UsersDAO;
import com.letzchat.collaboration.model.Blog;
import com.letzchat.collaboration.model.BlogComment;
import com.letzchat.collaboration.model.Forum;
import com.letzchat.collaboration.model.ForumComment;
import com.letzchat.collaboration.model.Friend;
import com.letzchat.collaboration.model.Job;
import com.letzchat.collaboration.model.Users;

@Configuration
@ComponentScan("com.letzchat.collaboration")
@EnableTransactionManagement
public class ApplicationConfig {
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		//Hibernate related properties
		Properties hibernateprop=new Properties();
		hibernateprop.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateprop.put("hibernate.show_sql", "true"); //optional
		hibernateprop.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		
		//Adding the Database related Properties
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("SEASON");
		dataSource.setPassword("SEASON");
		
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(hibernateprop);
		sessionBuilder.addAnnotatedClass(Blog.class);
		sessionBuilder.addAnnotatedClass(BlogComment.class);
		sessionBuilder.addAnnotatedClass(Forum.class);
		sessionBuilder.addAnnotatedClass(ForumComment.class);
		sessionBuilder.addAnnotatedClass(Friend.class);
		sessionBuilder.addAnnotatedClass(Job.class);
		sessionBuilder.addAnnotatedClass(Users.class);
		SessionFactory sessionfactory=sessionBuilder.buildSessionFactory();
		
		System.out.println("Session Factory Object Created");
		
		return sessionfactory;
		
	}
	
	@Bean(name="blogDAO")
	public BlogDAO getBlogDAO(SessionFactory sessionFactory)
	{
		return new BlogDAO(sessionFactory);
	}
	
	@Bean(name="blogcommentDAO")
	public BlogCommentDAO getBlogCommentDAO(SessionFactory sessionFactory)
	{
		return new BlogCommentDAO(sessionFactory);
	}
	@Bean(name="forumDAO")
	public ForumDAO getForumDAO(SessionFactory sessionFactory)
	{
		return new ForumDAO(sessionFactory);
	}
	
	@Bean(name="forumcommentDAO")
	public ForumCommentDAO getForumCommentDAO(SessionFactory sessionFactory)
	{
		return new ForumCommentDAO(sessionFactory);
	}
	
	@Bean(name="friendDAO")
	public FriendDAO getFriendDAO(SessionFactory sessionFactory)
	{
		return new FriendDAO(sessionFactory);
	}
	
	@Bean(name="jobDAO")
	public JobDAO getJobDAO(SessionFactory sessionFactory)
	{
		return new JobDAO(sessionFactory);
	}
	
	@Bean(name="usersDAO")
	public UsersDAO getUsersDAO(SessionFactory sessionFactory)
	{
		return new UsersDAO(sessionFactory);
	}
	
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Transaction Manager");
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
