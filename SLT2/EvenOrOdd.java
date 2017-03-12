import java.util.*;
public class EvenOrOdd {
	static int var1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter a number to check whether odd or even");
		var1= scan.nextInt();
		
		if (var1%2== 0)
		{
			System.out.println("Even number");
		}
		else
		{
			System.out.println("Odd number");
		}
	}

}
