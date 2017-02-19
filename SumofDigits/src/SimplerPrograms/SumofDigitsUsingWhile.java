package SimplerPrograms;

import java.util.Scanner;

public class SumofDigitsUsingWhile {
  private static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 int Number, Reminder, Sum= 0;
	 sc= new Scanner(System.in);
	 System.out.println("Please Enter any Number :");
	 Number= sc.nextInt();
	 
	 while(Number> 0){
	  Reminder= Number%10;
	  Sum= Sum+Reminder;
	  Number= Number/10;
	 }
    System.out.format("Sum of the digits of Given Number= %d", Sum);
	}

}
