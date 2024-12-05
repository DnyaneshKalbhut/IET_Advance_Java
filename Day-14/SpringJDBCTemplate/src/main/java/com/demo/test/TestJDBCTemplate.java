package com.demo.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class TestJDBCTemplate {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		Scanner sc = new Scanner(System.in);
		ProductService pservice=(ProductService)ctx.getBean("productServiceImpl");
		int choice=0;
		do {
			System.out.println("1. add new product\n 2. delete product\n 3. modify product\n");
			System.out.println("4. display by id\n 5. display all\n 6. display by price\n7.exit\nchoice: ");
			choice=sc.nextInt();
		switch(choice) {
		case 1 :
			pservice.addProduct();
			break;
			
        case 2 :
        	System.out.println("Enter id to delete");
        	int id = sc.nextInt();
			pservice.deleteById(id);
			break;
			
          case 3 :	
        	  System.out.println("Enter id to update");
               id =sc.nextInt();
               pservice.modifyByID(id);
        	  break;	
			
	        case 4:
	        	pservice.displayById();
			break;
        case 5 :
        	pservice.displayAll();
			break;
			
          case 6 :	
        	  pservice.displayByPrice();
			break;	
			
            case 7 :	
            	System.out.println("Thank you for visiting");
        	  sc.close();
			break;	
			
			default:
				System.out.println("error occured");
				break;
		}
		
		}while(choice!=6);	
        
	}

}
