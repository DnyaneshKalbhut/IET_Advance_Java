package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {
		
		try {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		String url = "jdbc:mysql://192.168.10.127:3306/dac24?useSSL=false";
		Connection conn = DriverManager.getConnection(url,"dac24","welcome");
		if(conn!=null) {
			System.out.println("connection succes");
		}else {
			System.out.println("connection unsuccessfull");
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
