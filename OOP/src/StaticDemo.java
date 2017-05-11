
public class StaticDemo {
	//instance member
	int var1;
	//static member
	static int var2;
	
	public StaticDemo()
	{
		var1++;
		var2++;
	}
	
	public static void display()
	{
		//var1= 10; //Error as var1 is non static variable
		System.out.println(var2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        StaticDemo ob1= new StaticDemo();
        
        System.out.println("After creation of Ob1:Var1:" +ob1.var1);
        System.out.println("After creation of Ob1:Var2:" +ob1.var2);
        
        StaticDemo ob2= new StaticDemo();
        
        System.out.println("After creation of Ob2:Var1:" +ob2.var1);
        System.out.println("After creation of Ob2:Var2:" +ob2.var2);
        
        StaticDemo ob3= new StaticDemo();
        
        System.out.println("After creation of Ob3:Var1:" +ob3.var1);
        System.out.println("After creation of Ob3:Var2:" +ob3.var2);
        
        System.out.println("With Class Name the Static Variable:" +StaticDemo.var2 );
        StaticDemo.display();
	}

}
