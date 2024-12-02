package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Customer;
import com.demo.beans.Employee;

public class TestMappedSuperClass {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Employee e = new Employee(1,"Dnyanesh","3232","test","coder");
		Customer c=new Customer(2,"Vikram","4444","baner","Rajeshwar");
		//objects cant be created which have notation Mapped Super class
		//Person p=new Person(141,"zzz","3333");  
		
		sess.save(e);
		sess.save(c);
		
		tr.commit();
		sess.close();
		sf.close();
		
	}

}
