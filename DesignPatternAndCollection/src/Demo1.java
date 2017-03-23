import java.util.regex.*;
public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//This is the target String where the search will happen
				String target="This the best example bust";
				
				//This is the pattern object which contain pattern String
				Pattern p=Pattern.compile("b.st");
				
				//Matcher object contains the info about the matches which 
				//occurred after pattern matches with target String
				
				Matcher m=p.matcher(target);
				
				//find() method of Matcher will return boolean value checks 
				//whether pattern is available in target String
				
				/*if(m.find())
				{
					System.out.println("The Pattern Found");
				}*/
				
				while(m.find())
				{
					System.out.println(m.group());
				}
				

	}

}
