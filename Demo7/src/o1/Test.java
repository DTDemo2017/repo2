package o1;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account aa= new Account(5000);
		try
		{
			aa.withdraw(1000);
			aa.deposit(500);
			aa.withdraw(20000);
		}
		
		catch(InsufficientBalanceException e)
		{
			System.out.println(e.getMessage());
		}
        System.out.println(aa.getBalance());
	}

}
