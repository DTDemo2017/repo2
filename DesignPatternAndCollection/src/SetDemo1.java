import java.util.*;
public class SetDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet hs=new HashSet();
		
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Enter the First Element");
		hs.add(scan.next());
		
		hs.add("Kiran");
		hs.add("Ankur");
		hs.add("Piyush");
		
		System.out.println("HashSet Values:"+hs);
		
		//TreeSet constructor will take another collection.
		TreeSet ts=new TreeSet(hs);
		
		System.out.println("TreeSet Values:"+ts);
		
		LinkedHashSet lhs=new LinkedHashSet();
		
		lhs.add("Fareed");
		lhs.add("Vinod");
		lhs.add("Mani");
		
		System.out.println("Linked HashSet :"+lhs);	

	}

}
