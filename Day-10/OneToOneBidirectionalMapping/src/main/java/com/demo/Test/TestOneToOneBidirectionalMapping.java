package com.demo.Test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import com.demo.beans.Course;
import com.demo.beans.Faculty;


public class TestOneToOneBidirectionalMapping {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Course c = new Course();
		c.setCname("Java");
		c.setDuration(40);
		
		Faculty f = new Faculty("ssss","fdfs",c);
		Session sess =sf.openSession();
		Transaction tr =sess.beginTransaction();
		sess.save(c);
		sess.save(f);
		tr.commit();
		sess.close();

	}

}
