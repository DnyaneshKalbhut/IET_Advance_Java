package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Customer;
import com.demo.beans.Employee;


public class TestInheritanceSingTable {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Employee e1 = new Employee(10,"vg","77777","hr","mgr");
		Employee e2 = new Employee(11,"dk","88888","IT","mgr");
		Customer c1 = new Customer(12,"cust1","99999","magarpatta","rajni");
		Customer c2 = new Customer(13,"cust2","121212","shivajinagar","raj");
		
		session.save(e1);
		session.save(e2);
		session.save(c1);
		session.save(c2);
		tr.commit();
		session.close();
		sf.close();
		
	}

}
