package jdbcdemo;

import java.util.ArrayList;
import java.util.Scanner;

import dao.StudentDao;
import dao.StudentDaoImpl;
import model.Student;

/**
 * 
 * @author Galaxy service
 */

public class JDBCDemo {
	/**
	 * @param args the command line arguments
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDao studentDao= new StudentDaoImpl();
		
		/*ArrayList<Student> students= studentDao.showStudents();
		
		for (Student s: students)
		{
			System.out.println(s.getName()+ " " +s.getMarks());
		}*/
		Scanner ss= new Scanner(System.in);
		System.out.println("Please enter a roll number:");
		
		int r= ss.nextInt();
		Student s= studentDao.showStudentByRoll(r);
        //Student s= studentDao.showStudentByRoll(x)
		
		if (s != null) 
		{
			System.out.println("Name" +s.getName());
		}
		else
		{
			System.out.println("There is no student with the roll" +r);
		}
	}

}
