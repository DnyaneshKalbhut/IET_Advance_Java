package com.demo.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FacultyTab")
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fid;
	private String name;
	private String address;
	
	@OneToOne(fetch=FetchType.LAZY  , cascade=CascadeType.ALL)
    @JoinColumn(name="courseid")
	private Course c1;
	public Faculty() {
		super();
	}
	public Faculty( String name, String address, Course c1) {
		super();
		this.name = name;
		this.address = address;
		this.c1 = c1;
	}
	public Faculty(int fid, String name, String address, Course c1) {
		super();
		this.fid = fid;
		this.name = name;
		this.address = address;
		this.c1 = c1;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Course getC() {
		return c1;
	}

	public void setC(Course c1) {
		this.c1 = c1;
	}

	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", name=" + name + ", address=" + address + ", c=" + c1 + "]";
	}
	
}
