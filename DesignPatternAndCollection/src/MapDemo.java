import java.util.*;
public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Map type interface will store two values one is key and second is value
		//Hence there are two generic values need to given in Map collection

		HashMap<String,String> hm=new HashMap<String,String>();
		
		hm.put("E1001","Suresh,Mumbai,suresh@yahoo.com,9988812121");
		hm.put("E1002","Ramesh,Mumbai,ramesh@yahoo.com,9988812121");
		hm.put("E1003","Vinod,Hyderabad,vinod@yahoo.com,9989762121");
		

		//hm.keySet() is a method which will return the keys which are stored 
		//in the HashMap. Here we have three keys (E1001,E1002,E1003)
		//Here keys is a set object which contains three values.

		//key is the single values which from keys which it receives

		Set<String> keys=hm.keySet();
		
		for(String key:keys)
		{
			System.out.print("Employee ID:"+key);
			
			String value=hm.get(key);
			String empvalues[]=value.split(",");
			
			System.out.print("Employee Name:"+empvalues[0]);
			System.out.println("Employee Address:"+empvalues[1]);
			
		}

	}

}
