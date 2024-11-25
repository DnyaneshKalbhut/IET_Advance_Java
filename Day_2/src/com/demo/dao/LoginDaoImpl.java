package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.MyUser;

public class LoginDaoImpl implements LoginDao{
	
	private static Connection conn;
	static PreparedStatement ps1 ;
	
	static {
		try {
			conn = DBUtil.getMyConnection();
			ps1 = conn.prepareStatement("select name , password,role from user where name=? and password=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public MyUser validate(String uname, String pwd) {
		try {
			ps1.setString(1, uname);
			ps1.setString(2,pwd);
			ResultSet rs = ps1.executeQuery();
			if(rs.next()) {
				return new MyUser(rs.getString(1),rs.getString(2),rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
