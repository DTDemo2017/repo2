
public class Boxmain {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box ob1= new Box(10, 15, 20);
        
        ob1.setWidth(10);
        ob1.setHeight(20);
        ob1.setDepth(15);
        
        System.out.println("Width value :" +ob1.getWidth());
        System.out.println("Height value :" +ob1.getHeight());
        System.out.println("Depth value :" +ob1.getDepth());
        
         
        
        Box mybox1= new Box(10, 20, 15);
        double vol;
        
        vol= mybox1.volume();
        
        System.out.println("Volume is " +vol);
	}

}
