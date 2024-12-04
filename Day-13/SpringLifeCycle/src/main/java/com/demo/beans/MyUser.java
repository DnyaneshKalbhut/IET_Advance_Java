package com.demo.beans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyUser implements BeanNameAware , BeanFactoryAware,ApplicationContextAware,InitializingBean,DisposableBean{
	
	private int id ;
	private String name;
	public MyUser() {
		super();
	}
	public MyUser(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "MyUser [id=" + id + ", name=" + name + "]";
	}
	
	public void setBeanName(String name) {
		System.out.println("int setBeanName "+name);
	}
	
	public void setBeanFactory(BeanFactory beanfactory) {
		System.out.println("In setBeanFactory "+beanfactory);
	}
	
	public void setApplicationContext(ApplicationContext applicationcontext) {
		System.out.println("In setApplicationContext "+applicationcontext);
	}
	
	public void afterPropertiesSet() throws Exception {
		System.out.println("in afterProperties set");
	}
	
	public void myinit() {
		System.out.println("in init method");
	}
	
	public void destroy() {
		System.out.println("in destroy method");
	}
	
	public void mydestroy() {
		System.out.println("in my destroy method");
	}
	
}
