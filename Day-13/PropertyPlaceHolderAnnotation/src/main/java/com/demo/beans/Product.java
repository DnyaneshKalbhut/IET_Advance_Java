package com.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Product {
 
	@Value("${prod.pid}") 
	private int pid;
	@Value("${prod.pname}")
	private String pname ;
	@Value("${prod.qty}")
	private int qty;
	@Autowired
    Category c;
	public Product() {
		super();
	}
	public Product(int pid, String pname, int qty, Category c) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.qty = qty;
		this.c = c;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Category getC() {
		return c;
	}
	public void setC(Category c) {
		this.c = c;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", c=" + c + "]";
	}
	
	
}
