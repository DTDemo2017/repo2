package com.niit;

public class Employee {
	private int id;
	private String name;
	private int sal;
	private char gender;
	
	public Employee()
	{
		this.id= id;
		this.name= name;
		if (gender=='m' || gender=='M' || gender=='f' || gender=='F')
			this.gender= gender;
		else{
			//System.out.println("Invalid gender.Please enter valid gender.");
			this.gender='M';
		}
	}
	
	/*public Employee(int id, String name, char gender)
	{this.id= id;
	 this.name= name;
	 this.gender= gender;
		
	}*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		if (sal<10_000 || sal>1_00_000)
		{
			System.out.println("Salary should be between 10K to 100K");
			sal=10_000;
		}
		this.sal = sal;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		if(gender=='m' || gender=='M' || gender=='f' || gender=='F')
		this.gender = gender;
		else
		{
			System.out.println("please provide M, m, F, f only");
		}
	}

	
	
	

}
