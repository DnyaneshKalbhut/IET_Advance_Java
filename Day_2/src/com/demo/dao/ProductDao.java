package com.demo.dao;

public interface ProductDao {

	boolean addProduct();

	boolean deleteById(int id);

	boolean updateById(int id);

	void displayAllProducts();

	boolean finById(int id);

	void displayInSortedName();

	void closeMyConnection();

}
