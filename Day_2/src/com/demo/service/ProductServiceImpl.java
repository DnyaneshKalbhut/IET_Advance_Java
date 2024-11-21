package com.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	Scanner sc = new Scanner(System.in);
	private ProductDao pdao;
	public ProductServiceImpl() {
		   super();
		   this.pdao = new ProductDaoImpl();
	}
	@Override
	public boolean addNewProduct() {
		System.out.println("enter id");
		int id = sc.nextInt();
		System.out.println("Enter price");
		double price = sc.nextDouble();
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("enter cid");
		int cid = sc.nextInt();
		System.out.println("Enter exp date");
		String exp = sc.next();
		LocalDate ldt = LocalDate.parse(exp, DateTimeFormatter.ofPattern("dd/MM/YYYY"));
		System.out.println("enter quanty");
		int qty = sc.nextInt();
		Product p = new Product(id, name, qty, price, ldt, cid); 
		return pdao.addNewProduct(p);
	}
	@Override
	public boolean removeById(int pid) {
	
		return pdao.removeById(pid);
	}
	@Override
	public boolean updateById(int pid, int qty, double price) {
		// TODO Auto-generated method stub
		return pdao.updateById(pid,qty,price);
	}
	@Override
	public List<Product> displayAll() {
	
	  return pdao.findAll();
		
	}
	@Override
	public Product getById(int id) {
		return pdao.findById(id);
	}

	
}
