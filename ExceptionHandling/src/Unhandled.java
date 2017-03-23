
public class Unhandled {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1, num2, result;
		num1= 42;
		num2= 0;
        result= num1/num2;//ArithmeticException
        System.out.println("Result:"+result);
        System.out.println("After the code");
	}

}
