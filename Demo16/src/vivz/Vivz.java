package vivz;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Vivz {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size");
        int size= Integer.parseInt(reader.readLine());
        
                for (int i= 1; i<=size; i++)
                {
                	for (int j= 1; j<= size;j++)
                	{ 
                		if (j<= i)
                		System.out.print("*");
                	}
                	System.out.println();
                }
	}

}
