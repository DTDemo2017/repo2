package com.niit.collaborationplatform.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.collaborationplatform.model.Job;

@Repository
public interface JobDAO {
	
	public boolean save(Job job);
	
	
	public boolean update(Job job);
		
		
	public boolean saveOrUpdate(Job job);
		
		
	public boolean delete(Job job);
		
		
	public Job get(int id);
		
		
	public List<Job> list();

}
