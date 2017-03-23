
public class Handled {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1, num2, result;
		num1= 42;
		num2= 0;
		try{
			result= num1/num2; //ArithmeticException (JVM will throw)
			System.out.println("Result:" +result);
		   }
		catch(ArithmeticException ae)
		{
			System.out.println("Exception Arised:::" +ae);
		}
        System.out.println("After the code");
	}

}
