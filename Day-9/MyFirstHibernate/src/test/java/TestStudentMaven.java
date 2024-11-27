import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Student;



public class TestStudentMaven {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Student s1 = new Student(1,"vg","77777",99);
		session.save(s1);
		tr.commit();
		session.close();
		sf.close();

	}

}
