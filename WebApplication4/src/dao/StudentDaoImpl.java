package dao;

import java.util.List;
import java.util.ArrayList;
import model.Student;

public class StudentDaoImpl implements StudentDao {
	// TODO Auto-generated methodstub
	@Override
	public ArrayList<Student> getAllStudent() {
		ArrayList<Student> students= new ArrayList<>();
		
		Student s1= new Student();
		s1.setStandard("ClassSix");
		s1.setRoll(01);
		s1.setName("AnamikaKumari");
		students.add(s1);
		
		Student s2= new Student();
		s2.setStandard("ClassSeven");
		s2.setRoll(01);
		s2.setName("AditiSingh");
		students.add(s2);
		
		Student s3= new Student();
		s3.setStandard("ClassEight");
		s3.setRoll(01);
		s3.setName("AnjaliSingh");
		students.add(s3);
		
		return students;
		 
	}

}
