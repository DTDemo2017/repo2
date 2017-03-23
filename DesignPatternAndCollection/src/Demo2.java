import java.util.*;
import java.util.regex.*;
public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String target="I have 20 rupees I want to Spend 80 rupees";
		
		Pattern p=Pattern.compile("\\d\\d");
		
		Matcher m=p.matcher(target);
		
		while(m.find())
		{
			System.out.println(m.group());
		}

	}

}
