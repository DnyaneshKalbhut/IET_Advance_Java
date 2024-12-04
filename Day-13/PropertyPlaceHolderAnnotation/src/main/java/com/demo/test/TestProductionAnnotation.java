package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Category;
import com.demo.beans.Product;

public class TestProductionAnnotation {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		Product p = (Product)ctx.getBean("product");
		Category c = (Category)ctx.getBean("category");
		System.out.println(p);
		System.out.println(c);
		((ClassPathXmlApplicationContext)ctx).close();

	}

}
