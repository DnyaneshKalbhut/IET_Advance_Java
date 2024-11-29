package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> showAllProduct();

	void insertProduct(Product p);

	Product getById(int pid);

	boolean deleteById(int pid);

}
