import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.Student1;

public class DisplayStudent1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Configuration cfg= new Configuration();
			cfg.configure("hibernate.cfg.xml");
			
			SessionFactory sessionfac= cfg.buildSessionFactory();
			Session session= sessionfac.openSession();
			
			Query query=session.createQuery("from Student1");
			
			
			List<Student1> list=query.list();
			
			for (Student1 s:list)
				{
				System.out.println(s);
				}
			session.close();
			
		}
		
		catch(Exception e){
			System.out.println("Exception Arised:" +e);
		}

	}

}
