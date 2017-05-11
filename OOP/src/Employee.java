
public class Employee {
	String empname;
	int empid, salary;
	
	public Employee()
	{
		System.out.println("I am in Constructor");
		empid= 1001;
		empname= "Gagan";
		salary= 45000;
	}	
		public void display()
		{
			System.out.println("Employee ID:" +empid);
			System.out.println("Employee Name:" +empname);
			System.out.println("Employee Salary:" +salary);
		}
	
		
		public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println("I am in Main Method");
			Employee obj= new Employee();
			obj.display();
			System.out.println("I am again in Main Method");
			
			
			
	}

}
