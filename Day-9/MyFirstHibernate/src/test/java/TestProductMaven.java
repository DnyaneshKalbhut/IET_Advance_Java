import org.hibernate.cfg.Configuration;

import com.demo.beans.Product;
import com.demo.beans.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TestProductMaven {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Student s1=new Student("Dnyanesh","4444",97);
		Student s2=new Student("Vikram"," 77777",99);
//		Product p1=new Product("table",23,4000);
//		Product p2=new Product("chair",45,3000);

		Session sess1 = sf.openSession();
		Transaction tr1 = sess1.beginTransaction();
	
		System.out.println("before get method");
		Student ss1 =sess1.get(Student.class,1);
		Student ss2 =sess1.get(Student.class,0);
		System.out.println(ss1);
		System.out.println(ss2);
		System.out.println("After get method");
//		Product pp1 = sess1.load(Product.class,2);
//		System.out.println("After get method");
//		System.out.println(pp1.getPname());
		tr1.commit();
		sess1.close();
		sf.close();
	
	}

}
