import java.util.*;
public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
TreeSet<Product> ts=new TreeSet<Product>();
		
		ts.add(new Product(1001,19000,"Samsung 7","4GMobile"));
		ts.add(new Product(1003,13000,"Samsung 8","4GMobile"));
		ts.add(new Product(1004,21000,"Samsung 9","4GMobile"));
		ts.add(new Product(1002,17000,"Samsung 5","4GMobile"));
		
		for(Product p:ts)
		{
			System.out.println(p);
		}

	}

}
