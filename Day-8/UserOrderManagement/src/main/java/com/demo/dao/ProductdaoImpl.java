package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Category;
import com.demo.beans.DBUtil;
import com.demo.beans.Product;


public class ProductdaoImpl implements ProductDao {
	
	static Connection conn;
	static PreparedStatement selcat,selProd,selById;
	static {
		
		try {
			conn=DBUtil.getMyConnection();
			selcat=conn.prepareStatement("select * from category");
			selProd=conn.prepareStatement("select * from product where cid=?");
			selById=conn.prepareStatement("select * from product where pid=?");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	@Override
	public List<Category> findAllCat() {
	
		try {
			List<Category> clist=new ArrayList<>();
			ResultSet rs= selcat.executeQuery();
			while(rs.next()) {
				clist.add(new Category(rs.getInt(1),rs.getString(2),rs.getString(3)));
				
			}
			return clist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}

		
		@Override
	public List<Product> findByid(int cid) {
		try {
			List<Product> plist=new ArrayList<>();
			selProd.setInt(1, cid);
			ResultSet rs=selProd.executeQuery();
			
			while(rs.next()) {
				plist.add(new Product(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getInt(6)));
			}
			if(plist.size()>0) {
				return plist;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


		@Override
		public Product ById(int pid) {
			try {
				selById.setInt(1, pid);
				ResultSet rs=selById.executeQuery();
				if(rs.next()) {
					return new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getInt(6));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
}
