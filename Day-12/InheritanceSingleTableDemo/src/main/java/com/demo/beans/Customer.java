package com.demo.beans;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("cust")
public class Customer extends Person {
	
	private String address;
	private String mgr;
	public Customer() {
		super();
	}
	public Customer(int pid, String pname, String mob,String address, String mgr) {
		super(pid,pname,mob);
		this.address = address;
		this.mgr = mgr;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMgr() {
		return mgr;
	}
	public void setMgr(String mgr) {
		this.mgr = mgr;
	}
	@Override
	public String toString() {
		return super.toString()+"Customer [address=" + address + ", mgr=" + mgr + "]";
	}
}
