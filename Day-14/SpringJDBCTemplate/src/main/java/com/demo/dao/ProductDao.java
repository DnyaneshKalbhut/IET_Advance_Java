package com.demo.dao;

import java.time.LocalDate;

import com.demo.beans.Product;

public interface ProductDao {

	void saveProduct(Product p);

	void findAll();

	void deleteById(int id);

	void editProduct(int id ,String name, int qty, double price, LocalDate ldt, int cid);

	void searchById(int id);

	void searchByPrice(double price);

}
