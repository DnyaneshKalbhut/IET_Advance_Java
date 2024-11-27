package com.demo.beans;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StudentTable1")
public class Student {
	
	@Id
	private int sid;
	private String sname;
	private float marks;
	@Embedded
	Address addr;
	public Student() {
		super();
	}
	public Student(int sid, String sname, float marks, Address addr) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.marks = marks;
		this.addr = addr;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", marks=" + marks + ", addr=" + addr + "]";
	}
	
	
}
