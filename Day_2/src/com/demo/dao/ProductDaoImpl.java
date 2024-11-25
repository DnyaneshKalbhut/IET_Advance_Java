package com.demo.dao;

import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductDaoImpl implements ProductDao {
	Scanner sc = new Scanner(System.in);
	private static Connection conn;
	static PreparedStatement padd,pdelete,pupdate,pdisplay,pfind,psort;
	static {
		try {
			conn =DBUtil.getMyConnection();
			padd = conn.prepareStatement("insert into products values(?,?,?,?,?,?)");
			pdelete=conn.prepareStatement("delete from products where pid = ?");
			pupdate=conn.prepareStatement("update products set qty = ? , price=? where pid = ?");
			pdisplay=conn.prepareStatement("Select * from products");
			pfind=conn.prepareStatement("select * from products where pid = ?");
			psort=conn.prepareStatement("select * from products order by name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean addProduct() {
		
		System.out.println("Enter Product id");
		int id = sc.nextInt();
		System.out.println("Enter Product Name");
		String name = sc.next();
		System.out.println("Enter Product Qty");
		int qty = sc.nextInt();
		System.out.println("Enter Product Price");
		double price = sc.nextDouble();
		System.out.println("Enter Product Expiry Date");
		String dt = sc.next();
		java.sql.Date std = Date.valueOf(dt);
		System.out.println("Enter Product Category id");
		int cid = sc.nextInt();
		try {
			padd.setInt(1, id);
			padd.setString(2, name);
			padd.setInt(3, qty);
			padd.setDouble(4, price);
			padd.setDate(5, std);
			padd.setInt(6, cid);
			int n = padd.executeUpdate();
			if(n>0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		
		try {
			pdelete.setInt(1, id);
			int n = pdelete.executeUpdate();
			if(n>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public boolean updateById(int id) {
		System.out.println("Enter New Quantity");
		int qty = sc.nextInt();
		System.out.println("Enter New Price");
		double price = sc.nextDouble();
		try {
			pupdate.setInt(1, qty);
			pupdate.setDouble(2, price);
			pupdate.setInt(3, id);
			int n = pupdate.executeUpdate();
			if(n>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void displayAllProducts() {
		try {
			ResultSet rs = pdisplay.executeQuery();
			while(rs.next()) {
				System.out.println("ID :"+rs.getInt(1));
				System.out.println("NAME :"+rs.getString(2));
				System.out.println("QTY :"+rs.getInt(3));
				System.out.println("PRICE :"+rs.getDouble(4));
				System.out.println("EXP DATE :"+rs.getDate(5));
				System.out.println("CID :"+rs.getInt(6));
				System.out.println("---------------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean finById(int id) {
		
		try {
			pfind.setInt(1, id);
			ResultSet rs = pfind.executeQuery();
			while(rs.next()) {
				System.out.println("ID :"+rs.getInt(1));
				System.out.println("NAME :"+rs.getString(2));
				System.out.println("QTY :"+rs.getInt(3));
				System.out.println("PRICE :"+rs.getDouble(4));
				System.out.println("EXP DATE :"+rs.getDate(5));
				System.out.println("CID :"+rs.getInt(6));
				System.out.println("---------------------------");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public void displayInSortedName() {
		try {
			ResultSet rs = psort.executeQuery();
			while(rs.next()) {
				System.out.println("ID :"+rs.getInt(1));
				System.out.println("NAME :"+rs.getString(2));
				System.out.println("QTY :"+rs.getInt(3));
				System.out.println("PRICE :"+rs.getDouble(4));
				System.out.println("EXP DATE :"+rs.getDate(5));
				System.out.println("CID :"+rs.getInt(6));
				System.out.println("---------------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void closeMyConnection() {
		DBUtil.closeMyConnection();
	}
	
}
