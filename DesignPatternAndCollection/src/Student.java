
public class Student {
	String studid, studname, addr;
	public Student(String sid, String sname, String addr)
	{
		studid= sid;
		studname= sname;
		this.addr= addr;
	}
	
	public String toString()
	{
		return"StudentID:"+studid+ "StudentName:" +studname+ "Address:" +addr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student ob= new Student("S1001", "Gagan", "Mumbai");
		System.out.println(ob);

	}

}
