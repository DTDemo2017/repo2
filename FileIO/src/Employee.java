
public class Employee implements java.io.Serializable {
	transient String passwd;
String empid,empname,address;
	
	public Employee(String eid,String ename,String addr)
	{
		this.empid=eid;
		this.empname=ename;
		this.address=addr;
		this.passwd= "pass123";
	}
    public String toString()
    {
    	return "Employee ID :" +empid+ "Employee Name :" +empname+ "Address :" +address+ "Password :" +passwd;
    }
}
