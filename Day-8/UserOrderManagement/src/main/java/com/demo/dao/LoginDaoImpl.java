package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.DBUtil;
import com.demo.beans.MyUser;

public class LoginDaoImpl implements LoginDao {
	static Connection conn;
	static PreparedStatement ps;
	static {
		try {
			conn=DBUtil.getMyConnection();
			ps=conn.prepareStatement("select name,password,role from user where name=? and password=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public MyUser authentication(String uname, String pass) {
		try {
			ps.setString(1, uname);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return new MyUser(rs.getString(1),rs.getString(2),rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
