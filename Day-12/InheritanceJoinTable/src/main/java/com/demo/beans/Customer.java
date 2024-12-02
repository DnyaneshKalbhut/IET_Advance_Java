package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cust_1")
public class Customer extends Person {
    private String addr;
    private String relmgr;
	public Customer() {
		super();
	}
	public Customer(int pid, String pname, String mob,String addr, String relmgr) {
		super(pid,pname,mob);
		this.addr = addr;
		this.relmgr = relmgr;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getRelmgr() {
		return relmgr;
	}
	public void setRelmgr(String relmgr) {
		this.relmgr = relmgr;
	}
	@Override
	public String toString() {
		return super.toString()+"Customer [addr=" + addr + ", relmgr=" + relmgr + "]";
	}
    
}
