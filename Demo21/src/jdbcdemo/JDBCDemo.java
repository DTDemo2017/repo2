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
		

       Scanner ss= new Scanner(System.in);
       System.out.println("Please enter a name");
       String r= ss.next();
       
       Student s=studentDao.showStudentByName(r);
       
       if (s== null)
       {
    	   System.out.println("There is no student of this name" );
       }
       else 
       {
    	   System.out.println( +s.getMarks());   
       }
	}

}
