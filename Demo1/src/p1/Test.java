package p1;
import p2.Employee;
import p2.TEmployee;
import p2.PEmployee;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x[];
		x =new int[5];
		
		x[0] =12;
		x[1] =34;
		x[2] =121;
		x[3] =126;
		x[4] =122;
		
		int sum =0;
	/*for (int i= 0; i< x.length; i++)
	  { 
	       sum+= x[i];
	       
	  }*/
	
	for (int a:x)
	{sum+= a;
	
	}
	System.out.println(sum);
	
	Employee e= new Employee (200, "Ram", 6000);
	int i = e.getId();
	System.out.println(i);
	  System.out.println(e.getId());
	  System.out.println(e.getSalary());
	  e.setId(100);
	  e.setSalary(5000);
	  System.out.println(e.getId());
	  System.out.println(e.getSalary());
	  
	  TEmployee te =new TEmployee(300,"Tom",7000,2);
	  te.display();
	  System.out.println(te.getName());
	  System.out.println(te.getId());
	  
	  PEmployee pe =new PEmployee(100,"Harry",4000,3000);
	  pe.display();
	}
	
	
}

	 

	


