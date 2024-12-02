package com.demo.services;

import java.util.List;

import com.demo.beans.Category;
import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductdaoImpl;

public class ProductServicesImpl implements ProductService {
	ProductDao pdao;
	
	
	public ProductServicesImpl() {
		super();
		this.pdao = new ProductdaoImpl();
	}


	@Override
	public List<Category> getAllCategory() {
		
		return pdao.findAllCat();
	}


	@Override
	public List<Product> getProductById(int cid) {
		// TODO Auto-generated method stub
		return pdao.findByid(cid);
	}


	@Override
	public Product getById(int pid) {
		// TODO Auto-generated method stub
		return pdao.ById(pid);
	}



}
