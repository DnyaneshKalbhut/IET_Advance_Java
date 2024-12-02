package com.demo.dao;

import java.util.List;

import com.demo.beans.Category;
import com.demo.beans.Product;


public interface ProductDao {

	List<Category> findAllCat();

	List<Product> findByid(int cid);

	Product ById(int pid);

}
