package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao {
	static Connection conn;
	static PreparedStatement getAll,proInsert,getById,deleteById;
	static {
		
		try {
			conn=DBUtil.getMyConnection();
			getAll=conn.prepareStatement("select * from products");
			proInsert=conn.prepareStatement("insert into products values(?,?,?,?,?,?)");
			getById=conn.prepareStatement("select * from products where id = ? ");
			deleteById=conn.prepareStatement("delete from product where id = ? ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Product> showAllProduct() {
		 List<Product>plist = new ArrayList<>();
		 
		 
		 try {
			ResultSet rs = getAll.executeQuery();
			while(rs.next()) {
				plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getInt(6)));
			}
			if(plist.size()>0) {
				return plist;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		
		
		return null;

}
	@Override
	public void insertProduct(Product p) {
		
		try {
			proInsert.setInt(1, p.getPid());
			proInsert.setString(2, p.getPname());
			proInsert.setInt(3, p.getQty());
			proInsert.setDouble(4,p.getPrice());
			proInsert.setDate(5,java.sql.Date.valueOf(p.getExpdate()));
			proInsert.setInt(6,p.getCid());
			int n = proInsert.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public Product getById(int pid) {
		try {
			getById.setInt(1, pid);
			ResultSet rs = getById.executeQuery();
			if(rs.next()) {
				return new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean deleteById(int pid) {
		
		try {
			deleteById.setInt(1, pid);
			int n = deleteById.executeUpdate();
			if(n>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
