package com.demo.test;

import java.util.Scanner;

import com.demo.beans.MyUser;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class TestCRUDOperation {

	public static void main(String[] args) {
		
		LoginService ls = new LoginServiceImpl();
		ProductService ps = new ProductServiceImpl();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter UserName");
		String uname = sc.next();
		System.out.println("Enter UserPassword");
		String pwd = sc.next();
		MyUser user = ls.validate(uname,pwd);
		int choice = 0 ;
		if(user!=null && user.getRole().equals("admin")) {
			System.out.println("1. Add new product\n2. Delete Product\n3. update product\n4.Display all");
			System.out.println("5. Find By ID\n6. display in sorted order by name\n7.exit\n choice:");
			choice = sc.nextInt();
			

			switch(choice) {
			
			case 1 -> {
				boolean status = ps.addProduct();
				if(status) {
					System.out.println("successfull Added New Product");
				}else {
					System.out.println("Error In Adding New Product");
				}
			}
			case 2 -> {
				System.out.println("Enter Product ID to Delete");
				int id = sc.nextInt();
				boolean status = ps.deleteProduct(id);
				if(status) {
					System.out.println("successfull Deleted Product");
				}else {
					System.out.println("Error In Deleting New Product");
				}
			}
			case 3 -> {
				System.out.println("Enter Product ID to Update");
				int id = sc.nextInt();
				boolean status = ps.updateProduct(id);
				if(status) {
					System.out.println("successfull Updated Product");
				}else {
					System.out.println("Error In Updating New Product");
				}
				
			}
			case 4 -> {
				ps.displayAllProducts();
			}
			case 5 -> {
				System.out.println("Enter Product ID to Find");
				int id = sc.nextInt();
				boolean status = ps.findProduct(id);
				if(status) {
					System.out.println("successfull Founded Product");
				}else {
					System.out.println("Error In Founding Product");
				}
			}
			case 6 -> {
				ps.displayInSortedName();
			}
			case 7 -> {
				System.out.println("ThankU For Your Service");
				sc.close();
				ps.closeMyConnection();
			}
			}
			
		}
	}

}
