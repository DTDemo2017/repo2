package com.letzchat.collaboration.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.letzchat.collaboration.dao.JobDAO;
import com.letzchat.collaboration.model.Job;

@RestController
public class JobController {
	
	@Autowired JobDAO jobDAO;
	@RequestMapping(value="/getJobs", method= RequestMethod.GET)
	
	public ResponseEntity<List<Job>> getAllJobs()
	{
		List<Job> listjobs=jobDAO.getAllJobs();
		return new ResponseEntity<List<Job>>(listjobs,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/insertJob", method=RequestMethod.POST)
	public ResponseEntity<String> insertJob(@RequestBody Job job)
	{
		job.setPostdate(new Date());
		job.setQualification("B.Tech");
		job.setStatus("APPROVE");
	
		
		jobDAO.insertJob(job);
		return new ResponseEntity<String>("Successfully Inserted", HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/deleteJob/{jobid}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteJob(@PathVariable("jobid") int jobid)
	{
		jobDAO.deleteJob(jobid);
		return new ResponseEntity<String>("Deleted Job Successfully",HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/updateJob/{jobid}", method=RequestMethod.PUT)
	public ResponseEntity<Job> updateJob(@PathVariable("jobid") int jobid,@RequestBody Job job)
	{
		Job curr_job=jobDAO.getJob(jobid);
		curr_job.setStatus(job.getStatus());
		jobDAO.insertJob(curr_job);
		return new ResponseEntity<Job>(curr_job,HttpStatus.OK);
		
	}

}
