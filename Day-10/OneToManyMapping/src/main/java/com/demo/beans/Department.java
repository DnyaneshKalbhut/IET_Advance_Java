package com.demo.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="	")
public class Department {
	@Id
	private int did ; 
	private String dname;
	private String dloc;
	@OneToMany(mappedBy = "d")
	Set<Employee> elsit;
	public Department() {
		super();
	}
	public Department(int did, String dname, String dloc, Set<Employee> elsit) {
		super();
		this.did = did;
		this.dname = dname;
		this.dloc = dloc;
		this.elsit = elsit;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDloc() {
		return dloc;
	}
	public void setDloc(String dloc) {
		this.dloc = dloc;
	}
	public Set<Employee> getElsit() {
		return elsit;
	}
	public void setElsit(Set<Employee> elsit) {
		this.elsit = elsit;
	}
	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + ", dloc=" + dloc + ", elsit=" + elsit + "]";
	}	
}
