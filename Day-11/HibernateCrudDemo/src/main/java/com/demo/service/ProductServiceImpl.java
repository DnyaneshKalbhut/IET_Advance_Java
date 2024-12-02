package com.demo.service;

import java.sql.Date;
import com.demo.beans.Product;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.demo.dao.HibernateUtil;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
       Scanner sc = new Scanner(System.in);
	ProductDao pdao ;
    public ProductServiceImpl() {
		pdao=new ProductDaoImpl();
	}
	@Override
	public void closeMyConnection() {
	  pdao.closeMyConnection();
		
	}
	@Override
	public boolean addNewProduct() {
	        System.out.println("Enter a Id");
	        int id = sc.nextInt();
	        System.out.println("Enter a name");
	        String name=sc.next();
	        System.out.println("Enter a Quantity");
	        int qty = sc.nextInt();
	        System.out.println("Enter Price");
	        double price=sc.nextDouble();
            System.out.println("Enter  Date");
            String dt = sc.next();
            LocalDate sd = LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	        System.out.println("Enter a Category Id");
	        int cid = sc.nextInt();
	       
	        Product p =new Product(id,name,qty,price,sd,cid);
	       
	        return pdao.addNewProduct(p);
	}
	@Override
	public List<Product> DisplayAll() {
		
		return pdao.findAll();
	}
	@Override
	public boolean deleteById(int id) {
		
		return pdao.deletById(id);
	}
	@Override
	public boolean updateById(int id, int qty, double price) {
		
		return pdao.modifyById(id,qty,price);
	}
	@Override
	public void displayById(int id) {
		pdao.displayById(id);
		
	}
	@Override
	public void sortByName() {
		pdao.sortByName();
		
	}

	
	
}
