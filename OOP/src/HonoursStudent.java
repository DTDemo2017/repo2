
public class HonoursStudent extends Student {
	String honours;
	
	public HonoursStudent()
	{
		System.out.println("Sub Class constructor");
		sid= 1001;
		studname= "Kiran";
		honours= "Physics";
	}
	
	public void show()
	{
		System.out.println("Honours Topic:" +honours);
	}
    
	public static void main(String[] args)
	{
		HonoursStudent obj= new HonoursStudent();
		obj.display();
		obj.show();
	}
}
