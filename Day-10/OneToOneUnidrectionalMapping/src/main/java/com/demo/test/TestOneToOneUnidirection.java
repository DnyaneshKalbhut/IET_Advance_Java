package com.demo.test;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;
import com.demo.beans.Faculty;


public class TestOneToOneUnidirection {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Course c = new Course(1,"Java",120);
		Faculty f = new Faculty(1,"Fac1","pune",c);
		session.save(c);
		session.save(f);
		
		tr.commit();
		session.close();
		sf.close();

	}

}
