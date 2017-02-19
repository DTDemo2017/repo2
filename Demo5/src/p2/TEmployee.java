package p2;

public class TEmployee extends Employee {
int shift;

public int getShift() {
	return shift;
}

public void setShift(int shift) {
	this.shift = shift;
}

public TEmployee(int id,String name, double salary, int shift)
{
	super(id, name, salary);//calling the parent class constructor
	this.shift= shift;
}
public void display()
{
System.out.println("Id :" +id);		
System.out.println("Name :" +name);
System.out.println("Salary :" +salary);
System.out.println("Shift :" +shift);
}

}
