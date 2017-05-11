
public class Triangle extends Shape {
	public Triangle(double d1, double d2)
	{
		super(d1,d2); //This will call shape class constructor
	}
    //Overriding
	public double area()
	{
		return dim1*dim2/2;
	}

  public void display()
  {
	  System.out.println("Triangle display method");

}
}
