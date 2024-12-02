package com.demo.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.demo.beans.Product;

public class TestCriteriaQuery {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		
		Criteria cr = sess.createCriteria(Product.class);
		List<Product> plist = cr.list();
		plist.forEach(System.out::println);
		Criterion cr1 = Restrictions.gt("price", 100);
		Criterion cr2 = Restrictions.gt("qty",20);
		Criteria cr3 = sess.createCriteria(Product.class);
		
		//select * from product where price>2000 or qty>35
		LogicalExpression expr = Restrictions.and(cr1, cr2);
		cr3.add(expr);
		List<Product> plist1=cr3.list();
		plist1.forEach(System.out::println);
		
		//select * from product where price>1000 and price< 3000 or qty<40
		Criteria cr12 = sess.createCriteria(Product.class);
		List<Product> plist11 = cr12.list(); 
		plist11.forEach(System.out::println);
		Criterion cr123=Restrictions.gt("price", 29);
		Criterion cr1234=Restrictions.lt("price", 230);
		Criterion cr12345=Restrictions.lt("qty", 30);
		Criteria cr123456=sess.createCriteria(Product.class);
		LogicalExpression expr1=Restrictions.and(cr123, cr1234);
		LogicalExpression expr12=Restrictions.or(expr1, cr12345);
		cr123456.add(expr12);
		List<Product> plist111=cr123456.list();
		plist111.forEach(System.out::println);
		
		
		
		
		
		
		
		tr.commit();
		sess.close();
		sf.close();
		
	}

}
