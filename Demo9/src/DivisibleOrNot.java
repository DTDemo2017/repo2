import java.util.Scanner;
public class DivisibleOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1, num2, num3;
        Scanner s= new Scanner(System.in);
        System.out.println("Enter an integer");
        num1= s.nextInt();
        
        //Let determine the divisibility of 5 and 6
        num2= num1%5;
        num3= num1%6;
        
        System.out.println();
        
        //Divisible by 5 and 6?
        //using equality and logical operators
        if((num2==0) && (num3==0))
        {
        	System.out.println("Is " +num1+ "divisible by 5 and 6? true");
        }
        else
        {
        	System.out.println("Is " +num1+ "divisible by 5 and 6? false");
        }
        
        //Divisible by 5 or 6?
        if((num2== 0) || (num3== 0))
        {
        	System.out.println("Is " +num1+ "divisible by 5 or 6? true");
        }
        else
        {
        	System.out.println("Is " +num1+ "divisible by 5 or 6? false");
        }
        
        //Divisible by 5 or 6 but not both?
        if(((num2== 0) ||(num3== 0)) && !((num2== 0) && (num3== 0))) 
        {
        	System.out.println("Is" +num1+ "divisible by 5 or 6 but not both? true");
        }
        else
        {
        	{
        		System.out.println("Is" +num1+ "divisible by 5 or 6 but not both? false");	
        	}
        }
	}

}
