
public class ThisEx 
{
	int var1;
	
	public ThisEx(int var1)
	{
		this.var1= var1;
	}
	
	public void display()
	{
		System.out.println(var1);
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThisEx ob= new ThisEx(100);
		ob.display();

	}

}
