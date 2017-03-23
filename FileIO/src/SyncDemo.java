
public class SyncDemo extends Thread {
	String tran[]={"Enter Pin","Validate Amount","Process Tran","Update Tran","Complete"};
	public void run()
	{
		Sync.showTransaction(tran);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SyncDemo T1=new SyncDemo();
		T1.setName("Harish");
		T1.start();
		
		SyncDemo T2=new SyncDemo();
		T2.setName("Vinod");
		T2.start();

	}

}
