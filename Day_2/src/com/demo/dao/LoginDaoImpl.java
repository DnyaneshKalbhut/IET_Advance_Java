package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.MyUser;

public class LoginDaoImpl implements LoginDao {
	private static Connection conn;
	private static PreparedStatement selUser;
	
	static {
		try {
			conn = DBUtil.getMyConnection();
			selUser = conn.prepareStatement("select name,password,role from user where name = ? and password=?");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public MyUser authenticate(String uname, String pwd) {
		try {
			selUser.setString(1, uname);
			selUser.setString(2, pwd);
			ResultSet rs = selUser.executeQuery();
			while(rs.next()) {
				return new MyUser(rs.getString(1),rs.getString(2),rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
