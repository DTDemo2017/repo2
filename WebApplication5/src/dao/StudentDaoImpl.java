package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import model.Student;

public class StudentDaoImpl implements StudentDao {
        // TODO Auto-generated method stub
		Connection con= null;
		PreparedStatement ps= null;
		ResultSet rs= null;
		
		@Override
		public ArrayList<Student> showStudents(){
			ArrayList<Student> list= new ArrayList<Student>();
			
			try{
				Class.forName("org.h2.Driver");
				con= DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
				ps= con.prepareStatement("select * from Student");
				rs= ps.executeQuery();
				
				while(rs.next()){
					//get the record from resultSet and store in variables
					int roll= rs.getInt("roll");
					String name= rs.getString("name");
					Double phone= rs.getDouble("phone");
					String email= rs.getString("email");
					int marks= rs.getInt("marks");
					Date dob= rs.getDate("dob");
					String standard= rs.getString("standard");
					
					
					//create blank model object
					Student s= new Student();
					
					//call setters
					s.setRoll(roll);
					s.setName(name);
					s.setPhone(phone);
					s.setEmail(email);
					s.setMarks(marks);
					s.setDob(dob);
					s.setStandard(standard);
					
					
					//add the model object to the list
					list.add(s);
				}

			}catch(SQLException e){
				System.err.println(e.getMessage());
			}
			 catch(ClassNotFoundException e){
				 //TODO Auto-generated catch block
				 e.printStackTrace();
			 }
		
		return list;
	}

}
