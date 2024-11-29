package com.demo.services;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	List<Product> getAllProduct();

	void insertProduct(Product p);

	Product getById(int pid);

	boolean deletById(int pid);

}
