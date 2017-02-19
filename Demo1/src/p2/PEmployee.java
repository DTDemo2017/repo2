package p2;

public class PEmployee extends Employee {
double bonus;

public double getBonus() {
	return bonus;
}

public void setBonus(double bonus) {
	this.bonus = bonus;
}

public PEmployee(int id, String name, double salary, double bonus)
{super (id,name,salary); //calling the parent class constructor
this.bonus= bonus;

}

public void display()
{ super.display();
  System.out.println("Bonus:" +bonus);
}


}
