package com.demo.test;

import java.sql.Statement;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class TestCreateStatement {

	public static void main(String[] args) {

		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url =  "jdbc:mysql://192.168.10.127:3306/dac24?useSSL=false";
			Connection conn=DriverManager.getConnection(url,"dac24","welcome");
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from products");
			
			while(rs.next()) {
				System.out.println("pid : "+rs.getInt(1));
				System.out.println("name : "+rs.getString(2));
				System.out.println("Qty : "+rs.getInt(3));
				System.out.println("Price: "+rs.getDouble(4));
				System.out.println("expiry date : "+rs.getDate(5));
				System.out.println("Cid: "+rs.getInt(6));
				System.out.println("-------------------------");
			}
			
			int pid = 24;
			String pname = "britania";
			int qty = 12;
			double price =123.33;
			LocalDate dt = LocalDate.of(2025, 12, 19);
			int cid = 1;
			String query = "insert into products values("+pid+",'"+pname+"',"+qty+","+price+",'"+dt+"',"+cid+")";
			int n = st.executeUpdate(query);
			if(n>0) 
			    System.out.println("insertion done!!");
				else
				System.out.println("error occured");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
