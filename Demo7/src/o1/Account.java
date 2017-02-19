package o1;

public class Account {
	int balance;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public Account (int b)
	{
		balance= b;
	}
	
	public void deposit(int a)
	{
		balance+= a;
	}
	
	public void withdraw(int a) throws InsufficientBalanceException
	{
		if (a> balance)
			throw new InsufficientBalanceException("InsufficientBalance");
		balance-= a;
	}
	

}
