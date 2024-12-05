package com.demo.beans;

import org.springframework.stereotype.Component;

@Component
public class MyClass {
	
	public void m1() {
		System.out.println("in m1 method");
	}
	
	public void m2() {
		System.out.println("in m2 method");
	}
	
	public void m3(int x) {
		System.out.println("in m3 method "+ x);
	}
	
	public void getX() {
		System.out.println("in getX method");
	}
}
