package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Product;


/**
 * 
 * @author Galaxy service
 *
 */


public class ProductDaoImpl implements ProductDao {
	// TODO Auto-generated method stub
	
	Connection con= null;
	PreparedStatement ps= null;
	ResultSet rs= null;


	@Override
	public ArrayList<Product> showProducts() {
		ArrayList<Product> list= new ArrayList<Product>();
		
		try{
			con= DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","sa");
			ps= con.prepareStatement("select * from Product");
			rs= ps.executeQuery();
			
			while (rs.next()){
				//get the record from resultSet and store in variables
				int productid= rs.getInt("productid");
				String productname= rs.getString("productname");
				int productprice= rs.getInt("productprice");
				String productdescription= rs.getString("productdescription");
				int categoryid= rs.getInt("categoryid");
				
				//create blank model obj
				Product p= new Product();
				
				//call setters
				p.setProductid(productid);
				p.setProductname(productname);
				p.setProductprice(productprice);
				p.setProductdescription(productdescription);
				p.setCategoryid(categoryid);
				
				//add the model obj to the list
				list.add(p);
			}
		}
		
			
			catch(SQLException e) {
				System.err.println(e.getMessage());
			}
			
		
		return list;
	
	}
}

