import java.util.Scanner;
import java.util.InputMismatchException;

public class AddNumbers 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
        int x, y, z;
        System.out.println("Enter two integers to calculate their sum");
        Scanner in= new Scanner(System.in);
        
        
        //try block
        try{
        	x= in.nextInt();
            y= in.nextInt();
        	z= x+y;
        	System.out.println("Sum :" +z);
           }
        
        //catch block
        
        catch(InputMismatchException e)
        {
        	System.err.println("Type number! ");
        }
	}

}
