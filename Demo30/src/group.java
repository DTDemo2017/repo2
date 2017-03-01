import java.util.*;
public class group {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner data= new Scanner(System.in);
		int num1, num2;
		double num;
		System.out.println("Enter a number");
		num1=data.nextInt();
		System.out.println("Enter a power of the number");
		num2=data.nextInt();
		// Finding power of a number
		num=Math.pow(num1,num2);
		System.out.println("Answer:"+num);

	}

}
