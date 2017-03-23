import java.util.*;
public class MultipleCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1= 42, num2, arr[]= {2,3,0};
		Scanner scan= new Scanner(System.in);
		try{
			System.out.println("Enter the value of num2");
			num2= scan.nextInt();
			int result = num1/arr[2];
			System.out.println("Result:" +result);
			
		   }
		catch(ArithmeticException ae1){
			System.out.println("ArithmeticException Occured:" +ae1);
		}
		catch(ArrayIndexOutOfBoundsException ae2){
			System.out.println("Array Index Out of Bounds Exception:" +ae2);
		}
		catch(Exception e)//Global catch Clause
		{
			System.out.println("Exception Occured :" +e);
		}
		

	}

}
