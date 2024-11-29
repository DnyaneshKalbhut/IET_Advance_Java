package com.demo.services;

import java.util.List;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {

	ProductDao pdao=new ProductDaoImpl();

	@Override
	public List<Product> getAllProduct() {
		
		return pdao.showAllProduct();
	}

	@Override
	public void insertProduct(Product p) {
		pdao.insertProduct(p);
		
	}

	@Override
	public Product getById(int pid) {
		
		return pdao.getById(pid);
	}

	@Override
	public boolean deletById(int pid) {

		return pdao.deleteById(pid);
	}
}
