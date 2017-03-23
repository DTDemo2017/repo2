import java.util.*;
public class UseBankingException {
	public void withdraw(int amt) throws BankingException{
		int depositamount= 1000;
		if((depositamount- amt)< 500)
			throw new BankingException();
		else
			System.out.println("Successful Transaction"); 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UseBankingException obj= new UseBankingException();
		int amt;
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter the amount");
		amt= scan.nextInt();
		try{
			obj.withdraw(amt);
		   }
		catch(BankingException e)
		{ 
			System.out.println("Exception arised:" +e);
		}

	}

}
