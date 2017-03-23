
public class MainThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Thread mt=Thread.currentThread();
		
		//Every thread will have a name and priority to display that
		
		System.out.println("Name of the Main Thread:"+mt.getName());
		System.out.println("Priority of the Main Thread:"+mt.getPriority());
		
		//we can change the name and the priority of thread.
		
		mt.setName("MyMainThread");
		mt.setPriority(8);
		
		System.out.println("Name of the Main Thread After Change:"+mt.getName());
		System.out.println("Priority of the Main Thread After Change:"+mt.getPriority());

	}

}
