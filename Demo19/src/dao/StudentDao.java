package dao;


import java.util.ArrayList;

import model.Student;

/**
 * 
 * @author Galaxy service
 */

public interface StudentDao {
	public ArrayList<Student> showStudents();
	//public Student showStudentByRoll (int roll;)
	public Student showStudentByRoll(int roll);

}
