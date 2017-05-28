package com.letzchat.collaboration;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.letzchat.collaboration.dao.JobDAO;
import com.letzchat.collaboration.model.Job;

public class JobTestCase {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.letzchat.collaboration");
		context.refresh();
		
		JobDAO jobDAO=(JobDAO)context.getBean("jobDAO");
		
        Job job= new Job();
		
		job.setJobid(1);
		job.setJobprofile("Web Developer using Java");
		job.setJobdesc("Kolkata");
		job.setQualification("B.Tech");
		job.setStatus("APPROVE");
		
		job.setPostdate(new Date());
		
		
		jobDAO.insertJob(job);
		System.out.println("Job Details Added");
		
       /* Job job= new Job();
		
		job.setJobid(2);
		job.setJobprofile("Web Developer using .NET");
		job.setJobdesc("Bangalore");
		job.setQualification("B.Tech");
		job.setStatus("APPROVE");
		
		job.setPostdate(new Date());
		
		
		jobDAO.insertJob(job);
		System.out.println("Job Details Added");*/
		
		//Retrieve the jobs
		/*List<Job> jobs= jobDAO.getAllJobs();
		for (Job j: jobs)
		{
			System.out.println(j.getJobid()+ ":");
			System.out.println(j.getJobprofile()+ ":");
			System.out.println(j.getJobdesc()+ ":");
			System.out.println(j.getQualification()+ ":");
			System.out.println(j.getStatus()+ ":");
			System.out.println(j.getPostdate()+ ":");
		}*/
		
		//Deleting a Job
		/*jobDAO.deleteJob(1);
		System.out.println("Job Deleted");*/
		
		
		//Change value of a column in Job
		/*Job job1=jobDAO.getJob(2);
		job1.setStatus("APPROVE");
		jobDAO.insertJob(job1);
		System.out.println("Job Updated");*/
		
		
		
		

	}

}
