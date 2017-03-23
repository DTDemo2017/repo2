
public class ChildThreadDemo extends Thread {
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.print(Thread.currentThread().getName());
			System.out.println(":i:"+i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChildThreadDemo T1=new ChildThreadDemo();
		T1.setName("Child1");
		System.out.println("Child Thread T1 Live Status-Before Start :"+T1.isAlive());
		T1.start(); //Will run the run method.
		System.out.println("Child Thread T1 Live Status :"+T1.isAlive());
		
		ChildThreadDemo T2=new ChildThreadDemo();
		T2.setName("Child2");
		T2.start(); //Will run the run method.
		

	}

}
