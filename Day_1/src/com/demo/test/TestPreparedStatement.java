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
		Connection conn;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.127:3306/dac24?useSSL=false";
		 conn=DriverManager.getConnection(url,"dac24","welcome");
	        
			PreparedStatement pst = conn.prepareStatement("select * from student");
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println("sid : " + rs.getInt(1));
				System.out.println("firstname : " + rs.getString(2));
				System.out.println("lastname : " + rs.getString(3));
			}
			
			int sid = 120;
			String firstname = "Vikram";
			String lastname = "Goswami";
			LocalDate dt = LocalDate.of(2001, 11, 10);
			java.sql.Date sdt=Date.valueOf(dt);
			String mail = "ssdasdsadsas";
			
			PreparedStatement pst1 = conn.prepareStatement("insert into student values(?,?,?,?,?)");
			pst1.setInt(1, sid);
			pst1.setString(2, firstname);
			pst1.setString(3, lastname);
			pst1.setDate(4, sdt);
			pst1.setString(5, mail);
			int n =pst1.executeUpdate();
			if(n>0) {
				System.out.println("insertion done");
			}
			else {
				System.out.println("error occured");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		

	}

}
