import org.hibernate.*;
import org.hibernate.cfg.*;

public class SaveStudent1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Configuration cfg= new Configuration();
			cfg.configure("hibernate.cfg.xml");
			
			SessionFactory sessionfac=cfg.buildSessionFactory();
			Session session= sessionfac.openSession();
			
			
			com.Student1 obj= new com.Student1();
			
			obj.setStudid(1004);
			obj.setStudname("Mukesh");
			obj.setAddr("Kolkata");
			
			Transaction tx= session.beginTransaction();
			session.save(obj);
			
			
			
			System.out.println("Object saved successfully..........!!");
			tx.commit();
			session.close();
			sessionfac.close();
		}
catch(Exception e){
	System.out.println("Exception Arised:" +e);
}
	}

}
