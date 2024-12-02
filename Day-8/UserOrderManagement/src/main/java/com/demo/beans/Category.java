package com.demo.beans;

public class Category {
	
	private int cid;
	private String cname;
	private String cdes;
	
	public Category() {
		super();
	}

	public Category(int cid, String cname, String cdes) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cdes = cdes;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCdes() {
		return cdes;
	}

	public void setCdes(String cdes) {
		this.cdes = cdes;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", cdes=" + cdes + "]";
	}
	
	

}
