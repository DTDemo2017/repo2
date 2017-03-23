import java.sql.*;
public class ShowTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Class.forName("org.h2.Driver");
			Connection conn= DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			Statement stmt= conn.createStatement();
			ResultSet rs= stmt.executeQuery("select * from Employee");
		   while(rs.next())
		   {
			   System.out.println(rs.getInt(1)+" ");
			   System.out.println(rs.getString(2)+" ");
			   System.out.println(rs.getInt(3)+" ");
			   System.out.println(rs.getString(4));
		   }
		   
		   stmt.close();
		   conn.close();

		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:" +e);
		}
		
	}

}
