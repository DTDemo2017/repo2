import java.util.*;
public class SetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet hs=new HashSet();
		
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Enter the First Element");
		hs.add(scan.next());
		
		hs.add("Kiran");
		hs.add("Vinod");
		
		System.out.println(hs);

	}

}
