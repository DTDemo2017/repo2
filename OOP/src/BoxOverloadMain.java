
public class BoxOverloadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoxOverload ob1= new BoxOverload();
		
		BoxOverload ob2= new BoxOverload(10);
		
		BoxOverload ob3= new BoxOverload(11, 12, 13);
		
		System.out.println("Volume of Default Box:" +ob1.volume());
		
		System.out.println("Volume of Square Box:" +ob2.volume());
		
		System.out.println("Volume of UserDefined Box:" +ob3.volume());

	}

}
