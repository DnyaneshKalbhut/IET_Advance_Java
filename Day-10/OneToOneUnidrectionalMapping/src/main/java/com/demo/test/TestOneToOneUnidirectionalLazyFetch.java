package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Faculty;

public class TestOneToOneUnidirectionalLazyFetch {

	public static void main(String[] args) {
	
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Faculty f=session.load(Faculty.class, 1);
		System.out.println(f.getFname()+"-----" +f.getAddress());
		System.out.println(f.getC1());
		
		tr.commit();
		session.close();
		sf.close();
	}

}
