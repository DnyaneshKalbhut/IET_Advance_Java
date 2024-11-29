package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="faculty1")
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fid ;
	private String fname;
	private String address;
	@OneToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="courseid")
	private Course c1;
	
	public Faculty() {
		super();
	}

	public Faculty(int fid, String fname, String address, Course c1) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.address = address;
		this.c1 = c1;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Course getC1() {
		return c1;
	}

	public void setC1(Course c1) {
		this.c1 = c1;
	}

	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", fname=" + fname + ", address=" + address + ", c1=" + c1 + "]";
	}

}
