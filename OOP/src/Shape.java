
public class Shape {
	double dim1, dim2;
	
	public Shape(double d1,double d2)
	{
		dim1= d1;
		dim2= d2;
	}
	
	public double area()
	{
		return 0.0;
	}
	
	public void show()
	{
		System.out.println("Dimension 1 value :" +dim1);
		System.out.println("Dimension 2 value :" +dim2);
	}

}
