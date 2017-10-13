package com.niit.collaborationplatform.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity

//@Table(name = "B_JOB")

@Component

public class Job extends BaseDomain implements Serializable {
	
private static final long serialVersionUID = 10L;

	
	/**
		 *  declare the database column names for Job... 
		 */
	@Id
	
	@SequenceGenerator(name="SEQ_GEN", sequenceName="SEQ_AUTO_JOB_ID", allocationSize=1)
		
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
		
	private int id;
	
	private String companyName;
	
	private String location;
	
	private String description;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date jobDate;
	
	private String status;
	
	private int posts;

	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getJobDate() {
		return jobDate;
	}

	public void setJobDate(Date jobDate) {
		this.jobDate = jobDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	public int getPosts() {
		return posts;
	}

	public void setPosts(int posts) {
		this.posts = posts;
	}
	
	
		

}
