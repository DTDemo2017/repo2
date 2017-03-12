import java.util.Scanner;
public class PerfectOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, sum= 0;
		Scanner s= new Scanner(System.in);
		System.out.println("Enter a number to check whether perfect or not");
		n= s.nextInt();
		for(int i=1; i<n; i++)
		    {
			if (n%i== 0)
		{
				sum= sum+i;
			
		}
			}
		if (sum==n)
		{
			System.out.println("Given number is perfect");
		}
		else
		{
			System.out.println("Given number is not perfect");
		}

	}

}
