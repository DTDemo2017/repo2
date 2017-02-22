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
	public ArrayList<Student> showStudents() {
		ArrayList<Student> list = new ArrayList<Student>();

		try {
			con = DriverManager.getConnection("jdbc:h2:tcp://local host/~/test", "sa", "sa");
			ps = con.prepareStatement("select * from Student");
			rs = ps.executeQuery();

			while (rs.next()) {
				// get the record from resultSet and store in variables
				int roll = rs.getInt("roll");
				String name = rs.getString("name");
				double phone = rs.getDouble("phone");
				String email = rs.getString("email");
				int marks = rs.getInt("marks");
				Date dob = rs.getDate("dob");

				// create blank model object
				Student s = new Student();

				// call setters
				s.setRoll(roll);
				s.setName(name);
				s.setPhone(phone);
				s.setEmail(email);
				s.setMarks(marks);
				s.setDob(dob);

				// add the model object to the list
				list.add(s);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return list;
	}

	@Override
	public Student showStudentByRoll(int roll)
	// TODO Auto-generated method stub
	{
		try {
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			ps = con.prepareStatement("select * from Student where roll= ?");
			ps.setDouble(1, roll);
			rs = ps.executeQuery();
			if (rs.next()) {
				int r = rs.getInt("roll");
				String name = rs.getString("name");
				double phone = rs.getDouble("phone");
				String email = rs.getString("email");
				int marks = rs.getInt("marks");
				Date dob = rs.getDate("dob");

				Student s = new Student();

				// call setters
				s.setRoll(r);
				s.setName(name);
				s.setPhone(phone);
				s.setEmail(email);
				s.setMarks(marks);
				s.setDob(dob);

				return s;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;

		}

	}
}
