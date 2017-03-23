import java.sql.*;
import java.util.*;
public class PreparedStatementDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Class.forName("org.h2.Driver");
			Connection conn= DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			PreparedStatement psmt= conn.prepareStatement("insert into Employee values(?,?,?,?)");
			
			int empid, salary;
			String empname, addr;
			
			Scanner scan= new Scanner(System.in);
			System.out.println("Enter Employee ID:");
			empid= scan.nextInt();
			
			System.out.println("Enter Employee Name:");
			empname= scan.next();
			
			System.out.println("Enter Employee Salary:");
			salary= scan.nextInt();
			
			System.out.println("Enter Employee Address:");
			addr= scan.next();
			
			psmt.setInt(1, empid);
			psmt.setString(2, empname);
			psmt.setInt(3, salary);
			psmt.setString(4, addr);
			
			int row_eff= psmt.executeUpdate();
			
			if(row_eff>0)
				System.out.println("Row Inserted");
			else
				System.out.println("Problem Occured");
			

		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:" +e);
		}

	}

}
