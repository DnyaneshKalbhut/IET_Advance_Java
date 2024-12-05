package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {
    Scanner sc = new Scanner(System.in);   

    @Autowired
	ProductDao pdao;
	
	@Override
	public void addProduct() {
		System.out.println("Enter pid");
		int pid = sc.nextInt();
		System.out.println("Enter name");
		String pname = sc.next();
		System.out.println("Enter Qty");
		int qty=sc.nextInt();
		System.out.println("Enter price");
		double price=sc.nextDouble();
		System.out.println("Enter date in dd/mm/yyyy");
		String dt = sc.next();
		LocalDate ldt = LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("enter cid");
		int cid =sc.nextInt();
		
		Product p=new Product(pid,pname,qty,price,ldt,cid);
		pdao.saveProduct(p);
	}

	@Override
	public void displayAll() {
		pdao.findAll();
		
	}

	@Override
	public void deleteById(int id) {
		
		pdao.deleteById(id);
		
	}

	@Override
	public void modifyByID(int id) {
		System.out.println("enter name to change");
		String name = sc.next();
		System.out.println("Enter qty");
		int qty = sc.nextInt();
		System.out.println("Enter price");
		double price=sc.nextDouble();
		System.out.println("Enter exp date");
		String dt = sc.next();
		LocalDate ldt = LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));	
		System.out.println("enter cid");
		int cid =sc.nextInt();
		pdao.editProduct(id,name,qty,price,ldt,cid);
	}

	@Override
	public void displayById() {
		System.out.println("Enter id");
		int id = sc.nextInt();
		pdao.searchById(id);
		
	}

	@Override
	public void displayByPrice() {
		System.out.println("Enter Price of Products to Display");
		double price = sc.nextDouble();
		pdao.searchByPrice(price);
		
	}

}
