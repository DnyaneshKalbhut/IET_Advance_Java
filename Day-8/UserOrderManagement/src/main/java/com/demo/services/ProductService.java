package com.demo.services;

import java.util.List;

import com.demo.beans.Category;
import com.demo.beans.Product;


public interface ProductService {

	List<Category> getAllCategory();

	List<Product> getProductById(int cid);

	Product getById(int parseInt);

}
