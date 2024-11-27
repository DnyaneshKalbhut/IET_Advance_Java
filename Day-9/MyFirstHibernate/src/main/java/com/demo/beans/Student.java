package com.demo.beans;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Student {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int sid;
		private String sname;
		private String mobile;
		private float marks;
		
		public Student() {
			super();
		}
		public Student(String sname, String mobile, float marks) {
			super();
			this.sname = sname;
			this.mobile = mobile;
			this.marks = marks;
		}
		public Student(int sid, String sname, String mobile, float marks) {
			super();
			this.sid = sid;
			this.sname = sname;
			this.mobile = mobile;
			this.marks = marks;
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
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public float getMarks() {
			return marks;
		}
		public void setMarks(float marks) {
			this.marks = marks;
		}
		@Override
		public String toString() {
			return "Student [sid=" + sid + ", sname=" + sname + ", mobile=" + mobile + ", marks=" + marks + "]";
		}

	

}
