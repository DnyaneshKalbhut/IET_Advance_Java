package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Customer;
import com.demo.beans.Employee;


public class TestRetriveData {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Employee e1 = session.get(Employee.class, 10);
		System.out.println(e1);
		Customer c1 = session.get(Customer.class, 12);
		System.out.println(c1);
		tr.commit();
		session.close();
		sf.close();
		
	}

}
