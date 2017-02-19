package p2;

public abstract class Employee {
	//member
	int id;
	String name;
	double salary;
	//member function
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
	abstract void display();
	{
	
	}

}
