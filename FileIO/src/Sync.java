
public class Sync {
	public synchronized static void showTransaction(String arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(Thread.currentThread().getName());
			System.out.println(arr[i]);
		}
	}

}
