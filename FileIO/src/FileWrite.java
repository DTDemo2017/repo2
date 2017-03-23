import java.io.*;
import java.util.*;
public class FileWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			FileOutputStream fos=new FileOutputStream("e:\\customer.txt",true);
			
			String str= "null";
			
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter the String");
			str=scan.next();
			
			for(int i=0;i<str.length();i++)
			{
				fos.write(str.charAt(i));	
			}
			
			fos.close();
			System.out.println("Content written to a File");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}

	}

}
