import javax.security.auth.callback.Callback;

public class UseCallBack implements Callback {
	public void callBack(int v1)
	{
		System.out.println("Interface Method:" +v1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UseCallBack ob1= new UseCallBack();
		ob1.callBack(100);

	}

}
