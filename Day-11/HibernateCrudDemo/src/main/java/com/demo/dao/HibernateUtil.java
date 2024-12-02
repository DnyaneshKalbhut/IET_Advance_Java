package com.demo.dao;

import org.hibernate.cfg.Configuration;

import org.hibernate.SessionFactory;

public class HibernateUtil {

	static SessionFactory sf = null;
	
	public static SessionFactory getMyConnection() {
		if(sf==null) {
			sf=new Configuration().configure().buildSessionFactory();
			
		}
		return sf;
		}
	
	
	public static void closeMyConnection() {
		sf.close();
	}
	
}
