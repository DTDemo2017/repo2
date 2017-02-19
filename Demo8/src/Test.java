import java.util.HashSet;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.HashMap;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> hs= new HashSet<String>();
		hs.add("india");
		hs.add("us");
		hs.add("russia");
		hs.add("pakistan");
		hs.add("srilanka");
		hs.add("bhutan");
		hs.add("nepal");
		hs.remove("india");
		
		for(String s:hs)
		{
			System.out.println(s);
		}
		    System.out.println(hs.size());
         /*ArrayList<String>hs= new ArrayList<String> ();
         hs.add("india");
         hs.add("us");
         hs.add("russia");
         hs.add("pakistan");
         hs.add("srilanka");
         hs.add("bhutan");
         hs.add("nepal");
         hs.add("russia");
         
         hs.add(3,"china");
         hs.remove(5);
         for(String s:hs)
         {
        	 System.out.println(s);
         }
             System.out.println(hs.size());
              
             System.out.println(hs.get(6));*/
		/*ArrayDeque<String> hs= new ArrayDeque<String>();
		//Stack lifo
		hs.push("india");
		hs.push("us");
		hs.push("russia");
		hs.push("pakistan");
		hs.push("srilanka");
		hs.push("bhutan");
		hs.push("nepal");
		hs.push("russia");
		
		hs.pop();
		for(String s:hs)
		{
			System.out.println(s);
		}
		    System.out.println(hs.size());*/
		/*ArrayDeque<String> hs= new ArrayDeque<String>();
		//Q fifo
		
		hs.add("india");
		hs.add("us");
		hs.add("russia");
		hs.add("pakistan");
		hs.add("srilanka");
		hs.add("bhutan");
		hs.add("nepal");
		hs.add("russia");
		
		hs.removeFirst();
		for (String s:hs)
		{
			System.out.println(s);
		}
		    System.out.println(hs.size());*/
		/*HashMap<String,String> hm= new HashMap<>();
		hm.put("S1", "AAAAA");
		hm.put("S2", "bbbbb");
		hm.put("S3", "ccccc");
		hm.put("S4", "ddd");
		hm.put("S5", "eee");
		
		System.out.println(hm.get("S3"));*/
		
	}

}
