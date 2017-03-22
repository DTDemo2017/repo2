import java.util.Arrays;
public class ArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// initializing three char arrays
		   char[] arr1 = new char[] { 'x', 'y', 'b', 'a' };
		   char[] arr2 = new char[] { 'y', 'x', 'a', 'b','z' };
		   char[] arr3 = new char[] { 'x', 'y', 'b', 'a' };
		    
		   // comparing arr1 and arr2
		   boolean retval1=Arrays.equals(arr1, arr2);
		   System.out.println("arr1 and arr2 equal: " + retval1);

		   // comparing arr1 and arr3
		   boolean retval2=Arrays.equals(arr1, arr3);
		   System.out.println("arr1 and arr3 equal: " + retval2);

	}

}
