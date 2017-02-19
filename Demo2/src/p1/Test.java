package p1;

import p2.Employee;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x[];
		x= new int[5];
		
		x[0]= 12;
		x[1]= 34;
		x[2]= 121;
		x[3]= 126;
		x[4]= 122;
		
		int sum= 0;
		
		/*for (int i= 0; i<x.length; i++)
		 {sum+= x[i];
		 }*/
		
		
		  for(int a:x)
		 
		{ sum+= a;
		
		}
        System.out.println(sum);
        Employee e= new Employee(200,"Ram", 6000);
        e.display();
        e.display("name");
	}

}
