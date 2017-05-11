
public class Box {
double width, height, depth, volume;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box obj= new Box();
		obj.width= 10;
		obj.height= 15;
		obj.depth= 20;
		double volume= obj.width*obj.height*obj.depth;
		System.out.println("Volume of the Box:" +obj.volume);

	}

}
