import java.io.*;
public class FileRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			FileInputStream fis=new FileInputStream("e:\\emp.txt");
			
			//read the number of bytes in the file
			int avl =fis.available();
			System.out.println("The Number of Bytes :"+avl);
			
			//Creating a byte array to read the data from file
			byte buff[]=new byte[avl];
			
			//file stream will read the data from 0th location until the avl position and it will store in buff
			fis.read(buff,0,avl);
			
			//Convert into the String
			String str=new String(buff);
			
			System.out.println(str);
			
			fis.close();
			
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
		
		

	}

}
