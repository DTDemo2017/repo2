import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.*;
public class ObjectReadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			FileInputStream fis=new FileInputStream("e:\\Employee1.txt");
			ObjectInputStream oos=new ObjectInputStream(fis);
			
			Employee ob=(Employee)oos.readObject();
			
			System.out.println(ob);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}

	}

}
