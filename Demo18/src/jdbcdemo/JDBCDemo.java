package jdbcdemo;
import java.util.ArrayList;
import dao.ProductDao;
import dao.ProductDaoImpl;

import model.Product;

/**
 * 
 * @author Galaxy service
 */

public class JDBCDemo {
  /**
   * 
   * @param args the command line arguments
   */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductDao productDao= new ProductDaoImpl();
		
		ArrayList<Product> products= productDao.showProducts();
		for (Product p: products)
		{
			System.out.println(p.getProductname()+" "+p.getProductprice());
		}
		
		//Product p= productDao.showProductByProductid(x)

	}

}
