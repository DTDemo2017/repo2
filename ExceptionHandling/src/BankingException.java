
public class BankingException extends Exception {
	public BankingException()
	{
		super("Balance is not sufficient");
	}
	public String toString()
	{
		return "Balance is not sufficient";
	}

}
