package com.demo.service;

import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
	
	ProductDao pdao;
	public ProductServiceImpl() {
		pdao=new ProductDaoImpl();
	}

	@Override
	public boolean addProduct() {
		
		return pdao.addProduct();
	}

	@Override
	public boolean deleteProduct(int id) {
		
		return pdao.deleteById(id);
	}

	@Override
	public boolean updateProduct(int id) {
		
		return pdao.updateById(id);
	}

	@Override
	public void displayAllProducts() {
		pdao.displayAllProducts();
		
	}

	@Override
	public boolean findProduct(int id) {
		// TODO Auto-generated method stub
		return pdao.finById(id);
	}

	@Override
	public void displayInSortedName() {
		pdao.displayInSortedName();
		
	}

	@Override
	public void closeMyConnection() {
		pdao.closeMyConnection();		
	}
}
