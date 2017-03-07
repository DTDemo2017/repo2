package dao;

import java.util.ArrayList;
import java.util.List;
import model.Product;

public class ProductDaoImpl implements ProductDao {
	// TODO Auto-generated method stub

	@Override
	public ArrayList<Product> getAllProduct() {
		ArrayList<Product> products= new ArrayList<>();
		
		Product p1= new Product();
		p1.setId(100);
		p1.setName("Pen");
		p1.setPrice(50);
		
		products.add(p1);
		
		Product p2= new Product();
		p2.setId(101);
		p2.setName("Pencil");
		p2.setPrice(10);
		
		products.add(p2);
		
		Product p3= new Product();
		p3.setId(102);
		p3.setName("Eraser");
		p3.setPrice(5);
		
		products.add(p3);
		
		
		
		return products;
	}

}
