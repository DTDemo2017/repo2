
public class MethodDemo {
    public int add(int v1,int v2)
    {
    	return v1+v2;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodDemo obj= new MethodDemo();
		
		int ret_val;
		ret_val= obj.add(10, 20);
		
		System.out.println("Return value :" +ret_val);

	}

}
