package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	void closeMyConnection();

	boolean addNewProduct();

	List<Product> DisplayAll();

	boolean deleteById(int id);

	boolean updateById(int id, int qty, double price);

	void displayById(int id);

	void sortByName();


}
