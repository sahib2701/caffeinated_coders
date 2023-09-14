package com.demo.dao;
import com.demo.beans.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;



public interface ProductDao {
	List<Product> fetchAllProducts() throws SQLException;
	int addProducts(Set<Product> products) throws SQLException;
	
}
