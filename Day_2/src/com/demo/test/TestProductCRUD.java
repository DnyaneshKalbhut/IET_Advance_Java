package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.MyUser ;
import com.demo.beans.Product;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class TestProductCRUD {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter user name:");
            String uname = sc.next();
            System.out.println("Enter user password:");
            String pwd = sc.next();
            LoginService ls = new LoginServiceImpl();
            MyUser  user = ls.validate(uname, pwd);
            ProductService ps = new ProductServiceImpl();

            if (user != null && user.getRole().equals("admin")) {
                int choice;
                do {
                    System.out.println("1. Add new product\n2. Delete Product\n3. Update product\n4. Display all");
                    System.out.println("5. Find By ID\n6. Display in sorted order by name\n7. Exit\nChoice:");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1 -> {
                        	boolean status = ps.addNewProduct();
            				if(status) {
            					System.out.println("insertion done");
            				}else {
            					System.out.println("error occured");
            				}
                        }
                        case 2 -> {
                            System.out.println("Enter product ID to delete:");
                            int pid = sc.nextInt();
                            boolean status = ps.removeById(pid);
                            if (status) {
                                System.out.println("Product removed");
                            } else {
                                System.out.println("Product not found");
                            }
                        }
                        case 3 -> {
                            System.out.println("Enter product ID to update:");
                            int pid = sc.nextInt();
                            System.out.println("Enter new quantity:");
                            int qty = sc.nextInt();
                            System.out.println("Enter new price:");
                            double price = sc.nextDouble();
                            boolean status = ps.updateById(pid, qty, price);
                            if (status) {
                                System.out.println("Product updated successfully");
                            } else {
                                System.out.println("Update failed or product not found");
                            }
                        }
                        case 4 -> {
                            List<Product> productList = ps.displayAll();
                            if (productList != null && !productList.isEmpty()) {
                                productList.forEach(System.out::println);
                            } else {
                                System.out.println("No products found");
                            }
                        }
                        case 5 -> {
                            System.out.println("Enter product ID to search:");
                            int id = sc.nextInt();
                            Product p = ps.getById(id);
                            if (p != null) {
                                System.out.println("Product found: " + p);
                            } else {
                                System.out.println("Product not");
                            }
                        }
            			case 6 -> {}
            			case 7 -> {
            				System.out.println("BYEBYEEEEE");
            				sc.close();
            				
            			}
            			
            			
            			}
            		}while(choice!=7);
            	}
            }
    }
}