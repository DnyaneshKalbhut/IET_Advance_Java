package com.demo.test;

import java.sql.Statement;
import java.time.LocalDate;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestCreateStatement {

	public static void main(String[] args) {
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.127:3306/dac24?useSSL=false";
			Connection conn=DriverManager.getConnection(url,"dac24","welcome");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from student");
			
			while(rs.next()) {
				System.out.println("sid : " + rs.getInt(1));
				System.out.println("firstname : " + rs.getString(2));
				System.out.println("lastname : " + rs.getString(3));
			}
			int sid = 118;
			String firstname = "DK";
			String lastname = "Kalbhut";
			LocalDate dt = LocalDate.of(2002, 10, 19);
			String mail = "skjlfjhnas";
			String query = "INSERT INTO` student VALUES (" + sid + ", '" + firstname + "', '" + lastname + "', '" + dt + "', '" + mail + "')";
			System.out.println(query);
			int n = st.executeUpdate(query);
			if(n>0)
				   System.out.println("insertion done!!");
				else
					System.out.println("error occured");
			
	}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
