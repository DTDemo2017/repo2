
public class BoxOverload {
	double width, height, depth;
	
	//Default Constructor- Default Box
	public BoxOverload()
	{
		width= 10;
		height= 15;
		depth= 20;
	}
	
	//Parameterized- Overloaded Constructor-Square Box
	public BoxOverload(double d)
	{
		width=height=depth=(d>0)?d:1;
	}
	
	//Overloaded Constructor - User Defined Box
	public BoxOverload(double w, double h, double d)
	{
		width=(w>0)?w:1;
		height=(h>0)?h:1;
		depth=(d>0)?d:1;
	}
	double volume()
	{
		return width* height*depth;
	}

}
