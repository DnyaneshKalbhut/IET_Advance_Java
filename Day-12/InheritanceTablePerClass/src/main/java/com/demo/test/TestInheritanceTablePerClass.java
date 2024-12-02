package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Customer;
import com.demo.beans.Employee;
import com.demo.beans.Person;

public class TestInheritanceTablePerClass {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		Employee e=new Employee(12,"vg","3333","hr","mgr");
		Customer c=new Customer(13,"dk","4444","baner","Rajesh");
		Person p=new Person(14,"perv","3333");
		sess.save(e);
		sess.save(c);
		sess.save(p);
		tr.commit();
		sess.close();
		sf.close();
	}

}
