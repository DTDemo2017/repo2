import java.io.FileInputStream;
public class TryResources {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(FileInputStream fis= new FileInputStream("e:\\emp14.txt"))
		{
		
		}
		catch (Exception fe)
		{
			System.out.println("Exception occurred:" +fe);
		}

	}

}
