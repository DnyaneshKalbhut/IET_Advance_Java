package com.demo.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.demo.beans.Address;
import com.demo.beans.Student;
public class TestEmbeddedDemo {
	public static void main(String[] args) {
		Address addr1 = new Address(1,"Pune","mh","411046");
		Student s1 = new Student(1,"vg",99,addr1); 
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(s1);
		tr.commit();
		session.close();
		sf.close();	
		
	}
}
