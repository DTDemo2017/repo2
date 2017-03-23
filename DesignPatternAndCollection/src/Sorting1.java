import java.util.*;
public class Sorting1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ArrayList<Product> list= new ArrayList<Product>();
		
		list.add(new Product(1001,19000,"Samsung 7","2GMobile"));
		list.add(new Product(1003,13000,"Lenovo P1","4GMobile"));
		list.add(new Product(1004,21000,"Redmi Note3","3GMobile"));
		list.add(new Product(1002,17000,"Moto G","4GMobile"));
		
		Collections.sort(list,new SortCatWise());
		
		
		for(Product p:list)
		{
			System.out.println(p);
		}

	}

}
