package com.letzchat.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.letzchat.collaboration.model.Job;

@Repository("jobDAO")
public class JobDAO {
public JobDAO(){}
	
	@Autowired
	SessionFactory sessionFactory;
	
	public JobDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		System.out.println("Constructor of Job");
	}
	
	@Transactional
	public void insertJob(com.letzchat.collaboration.model.Job job)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(job);
	}

	@Transactional
	public List <Job> getAllJobs()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Job");
		List<Job> jobs= query.list();
		session.close();
		
		return jobs;
		
	}
	
	@Transactional
	public void deleteJob(int jobid)
	{
		Job job=(Job)sessionFactory.getCurrentSession().get(Job.class, jobid);
		sessionFactory.getCurrentSession().delete(job);
	}
	
	@Transactional
	public Job getJob(int jobid)
	{
		Session session=sessionFactory.openSession();
		Job job=(Job)session.get(Job.class,  jobid);
		session.close();
		return job;
	}

	

}
