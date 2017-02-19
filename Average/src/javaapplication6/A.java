package javaapplication6;

public class A {
	double average (double ... a)
	{
	 double sum= 0;
	 for(double d:a)
	 {
		sum+= d;
	 }
	 double avg= sum/a.length;
	 return avg;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    A a1= new A();
    double d1= a1.average(123,345,67,89);
    double d2= a1.average(123,34,56,78,11,22,90,45,67,81);
    System.out.println("Avg 1" +d1);
    System.out.println("Avg 2" +d2);
    
    P p1= new R();
      p1= new Q();
      p1= new P();
    if (p1 instanceof R)
    {
    	System.out.println("AA");
    }
    else if (p1 instanceof Q)
    {
    	System.out.println("BB");
    }
    else
    	System.out.println("CC");
    
    
    Outer o= new Outer(100);
    Outer.Inner i= o.new Inner(200);
    i.sum();
	}

}
