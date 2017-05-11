
public class Overloading {
	public int add(int var1, int var2)
	{
		return var1+var2;
	}
	
	public int add(int var1, int var2, int var3)
	{
		return var1+var2+var3;
	}

	public double add(double v1,double v2)
	{
		return v1+v2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Overloading ob1= new Overloading();
		System.out.println("Two Integer Add Method:" +ob1.add(10, 20));
		System.out.println("Three Integer Add Method:" +ob1.add(10, 20,30));
		System.out.println("Double Add Method:" +ob1.add(100.89, 78.67));

	}

}
