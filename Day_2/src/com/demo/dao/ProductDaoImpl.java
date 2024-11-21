package com.demo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao {
    private Connection conn;
    private PreparedStatement pinsert, pdel, pupdate, pdis, pfind;

    public ProductDaoImpl() {
        try {
            conn = DBUtil.getMyConnection();
            pinsert = conn.prepareStatement("INSERT INTO product VALUES (?, ?, ?, ?, ?, ?)");
            pdel = conn.prepareStatement("DELETE FROM product WHERE id = ?");
            pupdate = conn.prepareStatement("UPDATE product SET qty = ?, price = ? WHERE id = ?");
            pdis = conn.prepareStatement("SELECT * FROM product");
            pfind = conn.prepareStatement("SELECT * FROM product WHERE id = ?");
        } catch (SQLException e) {
            e.printStackTrace(); // Consider using a logging framework
        }
    }

    @Override
    public boolean addNewProduct(Product p) {
        if (p == null) {
            return false; // or throw IllegalArgumentException
        }
        try {
            pinsert.setInt(1, p.getPid());
            pinsert.setDouble(2, p.getPrice());
            pinsert.setString(3, p.getPname());
            pinsert.setInt(4, p.getCid());
            pinsert.setDate(5, Date.valueOf(p.getExpdate()));
            pinsert.setInt(6, p.getQty());

            return pinsert.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Consider using a logging framework
        }
        return false;
    }

    @Override
    public boolean removeById(int pid) {
        try {
            pdel.setInt(1, pid);
            return pdel.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Consider using a logging framework
        }
        return false;
    }

    @Override
    public boolean updateById(int pid, int qty, double price) {
        try {
            pupdate.setInt(1, qty);
            pupdate.setDouble(2, price);
            pupdate.setInt(3, pid);
            return pupdate.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Consider using a logging framework
        }
        return false;
    }

    @Override
    public List<Product> findAll() {
        List<Product> ls = new ArrayList<>();
        try (ResultSet rs = pdis.executeQuery()) {
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(3), rs.getInt(6), rs.getDouble(2), rs.getDate(5).toLocalDate(), rs.getInt(4));
                ls.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider using a logging framework
        }
        return ls;
    }

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
//    @Override
//    public Product findById(int id) {
//        try {
//            pfind.setInt(1, id);
//            try (ResultSet rs = pfind.executeQuery()) {
//                if (rs.next