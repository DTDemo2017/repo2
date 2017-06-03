package com.niit.collaborationplatform.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationplatform.model.Blog;
import com.niit.collaborationplatform.model.Job;


@Repository("jobDAO")
@Transactional
public class JobDAOImpl implements JobDAO {
	
	
Logger log = Logger.getLogger(JobDAOImpl.class);
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public JobDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	
	public JobDAOImpl(){}

	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
	protected Session getSession(){
		return sessionFactory.openSession();
	}
	
	
	
	@Transactional
	public boolean save(Job job) {
		try{
			log.debug("**********Starting of save() method.");

			Session session = getSession();
			job.setJobDate(new Date(System.currentTimeMillis()));    
			//save current time as postDate
			job.setStatus("N");	
			// N = New, R = Rejected, A = Approved 
			
			session.save(job);
			session.flush();
			session.close();
			log.debug("**********End of save() method.");

			
			return true;
			}catch(Exception e){
				log.error("Error occured : " + e.getMessage());

				e.printStackTrace();
				return false;
			}
	}
	
	
	@Transactional
	public boolean update(Job job) {
		try{
			log.debug("**********Starting of update() method.");

			Session session = getSession();
			session.update(job);
			session.flush();
			session.close();
			
			
			log.debug("**********End of update() method.");

			return true;
			}catch(Exception e){
				log.error("Error occured : " + e.getMessage());

				e.printStackTrace();
				return false;
			}
	}
	
	
	@Transactional
	public boolean saveOrUpdate(Job job) {
		try{
			log.debug("**********Starting of saveOrUpdate() method.");

			Session session = getSession();
			session.saveOrUpdate(job);
			session.flush();
			session.close();
			log.debug("**********End of saveOrUpdate() method.");

			return true;
			}catch(Exception e){
				log.error("Error occured : " + e.getMessage());
				e.printStackTrace();
				return false;
			}
	}
	
	
	@Transactional
	public boolean delete(Job job) {
		try{
			log.debug("**********Starting of delete() method.");

			Session session = getSession();
			session.delete(job);
			session.flush();
			session.close();
			log.debug("**********End of delete() method.");

			return true;
		}catch (Exception e){
			log.error("Error occured : " + e.getMessage());

			e.printStackTrace();
			return false;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Job get(int id) {
		log.debug("**********Starting of get() method.");

		Session session = getSession();

		Query query = session.createQuery("from Job where id = ?");
		
		
		query.setInteger(0, id);
		log.debug("**********End of get() method.");
		return (Job) query.uniqueResult();
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Job> list() {
		log.debug("**********Starting of list() method.");

		Session session = getSession();

		Query query = session.createQuery("from Job");
		List<Job> jobList = query.list();
        session.close();
        log.debug("**********End of list() method.");

		return jobList;
	}

}
