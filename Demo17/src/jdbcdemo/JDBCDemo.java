package jdbcdemo;
import java.util.ArrayList;
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
		
		ArrayList<Student> students= studentDao.showStudents();
		for (Student s: students)
		{
			System.out.println(s.getName()+" "+s.getMarks());
		}
		
		//Student s= studentDao.showStudentByRoll(x)

	}

}
