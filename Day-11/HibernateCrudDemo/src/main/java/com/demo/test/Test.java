package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class Test {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
    ProductService pservice = new ProductServiceImpl();
    int choice =0;
    
    do {
    	System.out.println("1. Add new Product\n2. displayall products\n3. delete by id\n4. update by id\n");
		System.out.println("5. display by id\n 6. sort by name\n7.exit\n choice: ");
		choice=sc.nextInt();
		
		switch(choice) {
		case 1:
			boolean status =pservice.addNewProduct();
			if(status) {
				System.out.println("New Product added");
			}else {
				System.out.println("error occured");
			}
			break;
		case 2:
			List<Product> plist= pservice.DisplayAll();
			plist.forEach(System.out::println);
			break;
		case 3:
			System.out.println("Enter a Id");
			int id=sc.nextInt();
			 status =pservice.deleteById(id);
				if(status) {
					System.out.println(" Product deleted");
				}else {
					System.out.println("error occured");
				}
			break;
		case 4:
			System.out.println("Enter a Id");
			id=sc.nextInt();
			System.out.println("Enter new Quantity");
			int qty = sc.nextInt();
			System.out.println("Enter new Price");
			double price = sc.nextDouble();
			status =pservice.updateById(id,qty,price);
			if(status) {
				System.out.println(" Product Updated");
			}else {
				System.out.println("error occured");
			}
			break;
		case 5:
			System.out.println("Enter a Id");
			id=sc.nextInt();
			pservice.displayById(id);
			break;
		case 6:
			pservice.sortByName();
			break;
		case 7:
			System.out.println("Thank you for visiting");
			pservice.closeMyConnection();
			sc.close();
			break;
			
		}
		
    	
    }while(choice!=7);
	
	
	}

}
