import java.util.*;
public class PrimeOrNot {
	static int n;
	static int i;
	static int count=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan= new Scanner(System.in);
		System.out.println ("Enter a number to check whether prime or not");
		n= scan.nextInt();
		
		for(i=2;i<n;i++){
			if (n%i== 0){
				count++;
				break;
			}
			
		}
		if (count== 0)
		{System.out.println("This is a prime number");

	    }
		else
		{System.out.println("This is not a prime number");
		}
		}

}
