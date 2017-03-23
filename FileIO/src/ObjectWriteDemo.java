import java.io.*;
public class ObjectWriteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			FileOutputStream fos=new FileOutputStream("e:\\Employee1.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			
			Employee emp=new Employee("E1001","Suresh","Mumbai");
			
			oos.writeObject(emp);
			
			System.out.println("Object is Written");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
		
		
		

	}

}
