package com.demo.test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Product;

public class TestProduct {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		
		Product p1 = new Product(1,"Milk",30,29);
		Product p2 = new Product(2,"silk",20,100);
		Product p3 = new Product(3,"Nick",40,230);
		Product p4 = new Product(4,"Mick",60,10);
		
		sess.save(p1);
		sess.save(p2);
		sess.save(p3);
		sess.save(p4);
		tr.commit();
		sess.close();
		sf.close();
		
	}

}
