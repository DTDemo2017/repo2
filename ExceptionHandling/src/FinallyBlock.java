import java.io.*;
public class FinallyBlock {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fos = null;
		try{
			fos= new FileInputStream("e:\\emp14.txt");
		}
		catch(FileNotFoundException fe)
		{
			System.out.println("Exception Occurred :" +fe);
		}
        finally
        {
        	System.out.println("Finally Called");
        	fos.close();
        }
	}

}
