package com.demo.dao;



import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao{

	static SessionFactory sf;
	static {
		sf=HibernateUtil.getMyConnection();
	}
	
	
	@Override
	public void closeMyConnection() {
		HibernateUtil.closeMyConnection();
		
	}


	@Override
	public boolean addNewProduct(Product p) {
		Session sess = sf.openSession();
		Transaction tr =sess.beginTransaction();
		sess.save(p);
		tr.commit();
		sess.close();
		return true;
	}


	@Override
	public List<Product> findAll() {
		Session sess = sf.openSession();
		Transaction tr =sess.beginTransaction();
		
		Query query = sess.createQuery("From Product");
		
		List<Product> plist=query.getResultList();
		tr.commit();
		sess.close();
		return plist;
		
	}


	@Override
	public boolean deletById(int id) {
		Session sess = sf.openSession();
		Transaction tr =sess.beginTransaction();
	    Product p = sess.get(Product.class, id);
	    boolean status=false;
	    if(p!=null) {
	    	sess.delete(p);
           status=true;
	    }
	    tr.commit();
	    sess.close();
	    return status;
	}


	@Override
	public boolean modifyById(int id, int qty, double price) {
		Session sess = sf.openSession();
		Transaction tr =sess.beginTransaction();
		Product p = sess.get(Product.class, id);
		boolean status = false;
		if(p!=null) {
			p.setQty(qty);
			p.setPrice(price);
			status = true ;
		}
		tr.commit();
		sess.close();
		return status;
	}


	@Override
	public void displayById(int id) {
		
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Product p = session.get(Product.class, id);
		if(p!=null) {
		System.out.println(p);
	}
		else {
			System.out.println("error");
		}
	}


	@Override
	public void sortByName() {
		
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("from Product p order by p.pname ");
		List<Product> plist=query.getResultList();
		plist.forEach(System.out::println);
		tr.commit();
		session.close();
		
	}
	
	
}
