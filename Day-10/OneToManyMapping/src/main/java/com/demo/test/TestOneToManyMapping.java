package com.demo.test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Department;
import com.demo.beans.Employee;

public class TestOneToManyMapping {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Department d1 = new Department();
		d1.setDid(1);
		d1.setDname("Dept1");
		d1.setDloc("Pune");
		
		Department d2 = new Department();
		d2.setDid(2);
		d2.setDname("Dept2");
		d2.setDloc("Mumbai");
		//nt eid, String ename, double sal, LocalDate doj, Department d
		Employee e1 = new Employee(1,"VG",110500,LocalDate.of(2024,11,15),d1);
		Employee e2 = new Employee(2,"DK",11050,LocalDate.of(2024,1,15),d2);
		Employee e3 = new Employee(3,"V",10500,LocalDate.of(2024,10,15),d2);
		Employee e4 = new Employee(4,"D",110500,LocalDate.of(2024,7,15),d1);
		
		Set<Employee> s1 = new HashSet<>();
		s1.add(e1);
		s1.add(e2);
		d1.setElsit(s1);
		
		Set<Employee> s2 = new HashSet<>();
		s2.add(e3);
		s2.add(e4);
		d2.setElsit(s2);
		
		session.save(d1);
		session.save(d2);
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);
		tr.commit();
	}

}
