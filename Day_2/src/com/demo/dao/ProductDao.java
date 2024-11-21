package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	boolean addNewProduct(Product p);

	boolean removeById(int pid);

	boolean updateById(int pid, int qty, double price);

	List<Product> findAll();

	Product findById(int id);

}
