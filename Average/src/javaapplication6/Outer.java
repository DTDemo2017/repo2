package javaapplication6;

public class Outer {
	int x;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	Outer(int x)
	{
	  this.x=x;
	}
 class Inner
 {
   int y;
   Inner (int y)
   {
	   this.y= y;
   }
   public void sum()
   {
	 int z= x+y;
	 System.out.println("Sum=" +z);
	 
   }
 }
}
