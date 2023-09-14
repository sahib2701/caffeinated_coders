package com.demo.dao;

import java.sql.Connection;
import com.demo.beans.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class ProductDaoImpl implements ProductDao{
	private static Connection conn;
	private static PreparedStatement selectAllProducts, insertOrUpdateProducts;
	
	static {
		conn = DBUtil.getConnection();
		try {
			selectAllProducts = conn.prepareStatement("SELECT * FROM tbl_product");
			insertOrUpdateProducts = conn.prepareStatement("INSERT INTO tbl_product values(?,?,?,?,?) ON DUPLICATE KEY UPDATE name=?, price=?, category=?, company_id=?");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Product> fetchAllProducts() throws SQLException {
		List<Product> productList = new ArrayList<>();
		ResultSet rs = selectAllProducts.executeQuery();
		while(rs.next())
			productList.add(new Product(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4),rs.getInt(5)));
		return productList;
	}

	@Override
	public int addProducts(Set<Product> products) throws SQLException {
		int i=0;
		int[] updateInt;
		int insertOrUpdateCount = 0;
		for(Product product: products) {
			insertOrUpdateProducts.setInt(1, product.getProductId());
			insertOrUpdateProducts.setString(2, product.getProductName());
			insertOrUpdateProducts.setFloat(3, product.getProductPrice());
			insertOrUpdateProducts.setInt(4, product.getProductCategory());
			insertOrUpdateProducts.setInt(5, product.getCompanyId());
			insertOrUpdateProducts.setString(6, product.getProductName());
			insertOrUpdateProducts.setFloat(7, product.getProductPrice());
			insertOrUpdateProducts.setInt(8, product.getProductCategory());
			insertOrUpdateProducts.setInt(9, product.getCompanyId());
			
			insertOrUpdateProducts.addBatch();
			i++;
			if(i%10 == 0 || i==products.size()) {
				updateInt = insertOrUpdateProducts.executeBatch();
				for(int status: updateInt) {
					if(status > 0)
						insertOrUpdateCount ++;
				}
			}
		}
		return insertOrUpdateCount;
	}

	
	
//	public int addProducts((Set<Product> products) throws SQLException {
//		int i=0;
//		int[] updateInt;
//		int insertOrUpdateCount = 0;
//		for(Product product: products) {
//			insertOrUpdateProducts.setInt(1, product.getProductId());
//			insertOrUpdateProducts.setString(2, product.getProductName());
//			insertOrUpdateProducts.setFloat(3, product.getProductPrice());
//			insertOrUpdateProducts.setInt(4, product.getProductCategory());
//			insertOrUpdateProducts.setInt(5, product.getCompanyId());
//			insertOrUpdateProducts.setString(6, product.getProductName());
//			insertOrUpdateProducts.setFloat(7, product.getProductPrice());
//			insertOrUpdateProducts.setInt(8, product.getProductCategory());
//			insertOrUpdateProducts.setInt(9, product.getCompanyId());
//			
//			insertOrUpdateProducts.addBatch();
//			i++;
//			if(i%10 == 0 || i==products.size()) {
//				updateInt = insertOrUpdateProducts.executeBatch();
//				for(int status: updateInt) {
//					if(status > 0)
//						insertOrUpdateCount ++;
//				}
//			}
//		}
//		return insertOrUpdateCount;
//	}

	
}
