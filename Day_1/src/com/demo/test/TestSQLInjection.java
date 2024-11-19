package com.demo.test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class TestSQLInjection {

	public static void main(String[] args) {
		 
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.127:3306/dac24?useSSL=false";
			Connection conn=DriverManager.getConnection(url,"dac24","welcome");
			Statement st = conn.createStatement();
			String user="yyy";
			String lastname="xxx' or '1'='1";
			String query="select * from student where  namefirst='"+user+"' and   namelast='"+lastname+"'";
			System.out.println(query);
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				System.out.println("User : "+rs.getString(1));
				System.out.println("Password : "+rs.getString(2));
				System.out.println("role : "+rs.getString(3));
				System.out.println("-----------");
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
