import java.util.*;
public class GenericDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ArrayList<String> list= new ArrayList<String>();
		list.add("Suresh");
		list.add("Harish");
		
		//list.add(new Student("S1001","Suresh","Mumbai")); //Error
		
		//=====================================
		
		//Student ob=(Student)list.get(0); //Error
		
		String str=list.get(0); //Casting not necessary as it is generic
		
		System.out.println(str);
	}

}
