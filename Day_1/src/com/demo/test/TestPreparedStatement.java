package com.demo.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class TestPreparedStatement {

	public static void main(String[] args) {
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url =  "jdbc:mysql://192.168.10.127:3306/dac24?useSSL=false";
			Connection conn = DriverManager.getConnection(url,"dac24","welcome");
			PreparedStatement ps = conn.prepareStatement("select * from products");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("ID :" + rs.getInt(1));
				System.out.println("Name :" + rs.getString(2));
				System.out.println("Qty :" + rs.getInt(3));
				System.out.println("Price :" + rs.getDouble(4));
				System.out.println("Expire Date :" + rs.getDate(5));
				System.out.println("CID :" + rs.getInt(6));
				System.out.println("----------------------------");
				
			}
			int pid = 25;
			String pname = "ramen";
			int qty = 10;
			double price =50;
			LocalDate dt = LocalDate.of(2025, 12, 19);
			java.sql.Date sdt = Date.valueOf(dt);
			int cid = 11;
			PreparedStatement ps2 = conn.prepareStatement("insert into products values(?,?,?,?,?,?)");
			ps2.setInt(1,pid);
			ps2.setString(2,pname);
			ps2.setInt(3, qty);
			ps2.setDouble(4, price);
			ps2.setDate(5, sdt);
			ps2.setInt(6, cid);
			
			int n = ps2.executeUpdate();
			if(n>0) {
				System.out.println("insertion successfull");
			}else {
				System.out.println("insertion unsuccessfull");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
