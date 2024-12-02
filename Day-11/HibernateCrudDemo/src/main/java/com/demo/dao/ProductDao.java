package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	void closeMyConnection();

	boolean addNewProduct(Product p);

	List<Product> findAll();

	boolean deletById(int id);

	boolean modifyById(int id, int qty, double price);

	void displayById(int id);

	void sortByName();


}
