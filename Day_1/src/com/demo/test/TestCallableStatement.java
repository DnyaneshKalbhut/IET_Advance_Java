package com.demo.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestCallableStatement {

	public static void main(String[] args) {
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url =  "jdbc:mysql://192.168.10.127:3306/dac24?useSSL=false";
			Connection conn = DriverManager.getConnection(url,"dac24","welcome");
		   CallableStatement cst = conn.prepareCall("call pro1() ");
		   cst.execute();
		   ResultSet rs = cst.getResultSet();
		   while(rs.next()) {
			   String result=rs.getString("R1");
			   System.out.println(result);
		   }
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
