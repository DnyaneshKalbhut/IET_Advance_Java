package com.demo.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void saveProduct(Product p) {
		
		jdbcTemplate.update("insert into product values(?,?,?,?,?,?)",new Object[] {
				p.getPid(),p.getPname(),p.getQty(),p.getPrice(),p.getLdt(),p.getCid()
		});
		
	}

	

	@Override
	public void deleteById(int id) {
		int n = jdbcTemplate.update("delete from product where pid = ?",id);
		
	}

	@Override
	public void editProduct(int id ,String name, int qty, double price, LocalDate ldt, int cid) {
		int n = jdbcTemplate.update("update product set name = ? , qty = ? , price=?, ExpiryDate = ?, cid = ? where pid=? ", 
                new Object[] {name, qty, price, ldt, cid,id});

	}

	@Override
	public void findAll() {
		List<Product> plist = jdbcTemplate.query("select * from product",(rs,numrows)->{
			Product p = new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(3));
			p.setPrice(rs.getDouble(4));
			p.setLdt(rs.getDate(5).toLocalDate());
			p.setCid(rs.getInt(6));
			return p;	
		});
		plist.forEach(System.out::println);
	}



	@Override
	public void searchById(int id) {
		Product p = jdbcTemplate.queryForObject("select * from product where pid = ?", new Object[] {id},BeanPropertyRowMapper.newInstance(Product.class));
		System.out.println(p);
	}



	@Override
	public void searchByPrice(double price) {
		List<Product> plist = jdbcTemplate.query("select * from product where Price = ? ", new Object[] {price},BeanPropertyRowMapper.newInstance(Product.class));
		plist.forEach(System.out::println);
	}
	
	
	
	
}
