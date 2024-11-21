package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	boolean addNewProduct();

	boolean removeById(int pid);

	boolean updateById(int pid, int qty, double price);

	List<Product> displayAll();

	Product getById(int id);

}
