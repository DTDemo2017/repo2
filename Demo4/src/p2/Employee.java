package p2;

public final class Employee {
	//member
	protected final int id;
	String name;
	double salary;
	//member function
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Employee(int id, String name, double salary)
	{
		this.id= id;
		this.name= name;
		this.salary= salary;
	}
    public final void display()
    {
    	System.out.println("Id :" +id);
    	System.out.println("Name :" +name);
    	System.out.println("Salary :" +salary);
    }
}
