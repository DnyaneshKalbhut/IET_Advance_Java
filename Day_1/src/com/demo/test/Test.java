package com.demo.test;

import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {
		int pid = 24;
		String pname = "britania";
		int qty = 12;
		double price =123.33;
		LocalDate dt = LocalDate.of(2025, 12, 19);
		int cid = 1;
		String query = "insert into products values("+pid+",'"+pname+"',"+qty+","+price+",'"+dt+"',"+cid+")";
         System.out.println(query);
	}

}
