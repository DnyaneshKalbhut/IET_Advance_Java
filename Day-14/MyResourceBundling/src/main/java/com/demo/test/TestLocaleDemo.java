package com.demo.test;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;

public class TestLocaleDemo {

	public static void main(String[] args) {
		
		ApplicationContext ctx =new ClassPathXmlApplicationContext("springconfig.xml");
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			
		System.out.println("1. US english\2. UK english\n 3. Marathi\n4. other\n5. exit\n choice:");
		System.out.println("select language");
		MessageSource ms = (MessageSource)ctx.getBean(ResourceBundleMessageSource.class);
		String m=null,w=null,d=null,c=null;
		choice=sc.nextInt();
		Locale locale=null;
		
		switch(choice) {
		case 1 :
			locale=Locale.US;
			System.out.println("Country :" + locale.getCountry()+"Langauge : "+ locale.getLanguage());
			break;
		case 2 :
			locale=Locale.UK;
			System.out.println("Country :" + locale.getCountry()+"Langauge : "+ locale.getLanguage());
			break;
		case 3 :
			locale = new Locale("my","marathi");
			System.out.println("Country :" + locale.getCountry()+"Langauge : "+ locale.getLanguage());
			break;
		case 4 :
			locale = new Locale("aa","test");			
			break;
		case 5:
			System.out.println("Thank you for visiting....");
			sc.close();
			break;
		default:
			System.out.println("invalid choice");
			break;
		}
		
		
		m=ms.getMessage("msg.pay",null, locale);
		w= ms.getMessage("msg.welcome",new Object[] {"kishori"},locale);
		d=ms.getMessage("msg.data", null,locale);
		w=ms.getMessage( "msg.currency",null, locale);
		System.out.println("pay : "+m);
		System.out.println("Welcome : "+w);
		System.out.println("data : "+d);
		System.out.println("currency : "+c);
		
		
		
		}while(choice!=5);
	}

}
