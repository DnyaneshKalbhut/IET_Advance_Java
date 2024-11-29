package com.demo.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;
import com.demo.beans.Student;

public class TestManyToManyBidirectionalMapping {

	public static void main(String[] args) {
	
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Student s1=new Student();
		s1.setSid(10);
		s1.setSname("aaa");
		
		Student s2=new Student();
		s2.setSid(20);
		s2.setSname("bbb");
		
		Student s3=new Student();
		s3.setSid(30);
		s3.setSname("ccc");
		
		Student s4=new Student();
		s4.setSid(40);
		s4.setSname("ddd");
		
		Course c1=new Course();
		c1.setCid(100);
		c1.setCname("Java");
		
		Course c2=new Course();
		c2.setCid(200);
		c2.setCname("C++");
		
		Course c3=new Course();
		c3.setCid(300);
		c3.setCname("Python");
		
		Course c4=new Course();
		c4.setCid(400);
		c4.setCname("Perl");
		
		
		Set<Student> sset1=new HashSet<>();
		sset1.add(s1);
		sset1.add(s2);
		sset1.add(s4);
		
		Set<Student> sset2=new HashSet<>();
		sset2.add(s1);
		sset2.add(s2);
		
		Set<Student> sset3=new HashSet<>();
		sset3.add(s3);
		sset3.add(s4);
		
		Set<Student> sset4=new HashSet<>();
		sset4.add(s3);
		
		Set<Course> cset1=new HashSet<>();
		cset1.add(c1);
		cset1.add(c2);
		
		Set<Course> cset2=new HashSet<>();
		cset2.add(c3);
		cset2.add(c4);
		
		Set<Course> cset3=new HashSet<>();
		cset3.add(c1);
		cset3.add(c3);
		
		s1.setClist(cset1);
		s2.setClist(cset1);
		s3.setClist(cset2);
		s4.setClist(cset3);
		
		c1.setSlist(sset1);
		c2.setSlist(sset2);
		c3.setSlist(sset3);
		c4.setSlist(sset4);
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		sess.save(c1);
		sess.save(c2);
		sess.save(c3);
		sess.save(c4);
		sess.save(s1);
		sess.save(s2);
		sess.save(s3);
		sess.save(s4);
		tr.commit();
		sess.close();
		sf.close();

	}
	}


