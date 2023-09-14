package com.demo.service;

import java.sql.SQLException;

import java.util.List;
import java.util.Set;

import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;
import com.demo.beans.Product;

public class ProductServiceImpl implements ProductService{
	private ProductDao productDao;
	
	// Default constructor
	public ProductServiceImpl() {
		productDao = new ProductDaoImpl();
	}
	
	@Override
	public int addProductsFromFile(Set<Product> products) throws SQLException {
		return productDao.addProducts(products);
	}

	@Override
	public List<Product> getAllProducts() throws SQLException {
		return productDao.fetchAllProducts();
	}
}
