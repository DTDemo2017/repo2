
public class RunnableDemo implements Runnable  {
	@Override
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
        RunnableDemo rtarget=new RunnableDemo();
		
		Thread T1=new Thread(rtarget);
		T1.start();
		
		Thread T2=new Thread(rtarget);
		T2.start();

	}

}
