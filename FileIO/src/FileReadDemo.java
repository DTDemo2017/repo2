import java.io.*;
public class FileReadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			FileReader fr=new FileReader("e:\\customer.txt");
			
			char content[]=new char[128];
			
			fr.read(content);
			
			String str=new String(content);
			
			System.out.println(str);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
		

	}

}
