package com.demo.service;

import java.sql.SQLException;

import java.util.List;
import java.util.Set;

import com.demo.beans.Product;

public interface ProductService {
	int addProductsFromFile(Set<Product> products) throws SQLException;
	
	List<Product> getAllProducts() throws SQLException;
}
