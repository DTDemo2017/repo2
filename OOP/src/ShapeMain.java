
public class ShapeMain {
	//Generalized Calculate Area method which should calculate area of any shape
	
	public void calcArea(Shape obj)
	{
		if(obj instanceof Rectangle)
		{
			System.out.println("Area of Rectangle:" +obj.area());
		}
		else if(obj instanceof Triangle) 
		{
			System.out.println("Area of Triangle:" +obj.area());
		}
		else
		{
			System.out.println("Invalid");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShapeMain ob= new ShapeMain();
		ob.calcArea(new Rectangle(10, 20));
		ob.calcArea(new Triangle(10, 20));

	}

}
