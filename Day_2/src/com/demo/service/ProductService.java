package com.demo.service;

public interface ProductService {

	boolean addProduct();

	boolean deleteProduct(int id);

	boolean updateProduct(int id);

	void displayAllProducts();

	boolean findProduct(int id);

	void displayInSortedName();

	void closeMyConnection();

}
