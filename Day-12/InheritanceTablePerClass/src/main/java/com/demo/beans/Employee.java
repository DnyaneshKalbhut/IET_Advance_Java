package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="emp_2")
public class Employee extends Person {
	
	private String mgr;
	private String desg;
	public Employee() {
		super();
	}
	public Employee(int pid, String pname, String mob,String mgr, String desg) {
		super(pid,pname,mob);
		this.mgr = mgr;
		this.desg = desg;
	}
	public String getMgr() {
		return mgr;
	}
	public void setMgr(String mgr) {
		this.mgr = mgr;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	@Override
	public String toString() {
		return super.toString()+"Customer [mgr=" + mgr + ", desg=" + desg + "]";
	}
	
	
}
