import java.util.Scanner;

public class JavaApplication7 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		int no1, no2, result;
		try
		{
		System.out.println("Enter number 1");
		no1= s.nextInt();
		System.out.println("Enter number 2");
		no2= s.nextInt();
		
		result= no1/no2;
		System.out.println("Result" +result);
	    }
        
		catch ( Exception e)
        {
			
        	System.out.println("You cannot divide the number by zero");
        }
        
		finally
        {
        	System.out.println("Good Bye");
        }
	}

}
