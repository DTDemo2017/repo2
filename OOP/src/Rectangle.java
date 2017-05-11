
public class Rectangle extends Shape {
	public Rectangle(double d1, double d2)
	{
		super(d1,d2); //This will call shape class constructor
	}
    //Overriding
	public double area()
	{
		return dim1*dim2;
	}

  public void display()
  {
	  System.out.println("Rectangle display method");
  }
}