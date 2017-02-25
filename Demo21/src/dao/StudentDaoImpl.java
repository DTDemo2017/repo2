package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Student;

/**
 * 
 * @author Galaxy service
 */

public class StudentDaoImpl implements StudentDao {
	// TODO Auto-generated method stub
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public Student showStudentByName(String name) {
		// ArrayList<Student> list= new ArrayList<Student> ();
		
		try{
			con= DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			ps= con.prepareStatement("select * from Student where name= ?");
			ps.setString(1, name);
			rs= ps.executeQuery();
			if (rs.next()){
				//get the record from resultSet and store in variables
				int roll= rs.getInt("roll");
				String n= rs.getString("name");
				Double phone= rs.getDouble("phone");
				String email= rs.getString("email");
				int marks= rs.getInt("marks");
				Date dob= rs.getDate("dob");
				
				//create blank model object
				Student s= new Student();
				
				//call setters
				s.setRoll(roll);
				s.setName(n);
				s.setPhone(phone);
				s.setEmail(email);
				s.setMarks(marks);
				s.setDob(dob);
				
				return s;
			}
			else
			{
				return null;
			}
		}catch (SQLException e){
			System.err.println(e.getMessage());
			return null;
		}
		
		
	}

	/*@Override
	public ArrayList<Student> showStudents() {
		// TODO Auto-generated method stub
		return null;
	}*/

}
