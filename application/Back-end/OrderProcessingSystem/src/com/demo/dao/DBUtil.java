package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection conn;
	
	public static Connection getConnection() {
		if(conn == null) {
			String url = "jdbc:mysql://localhost:3306/order_processing_system?allowPublicKeyRetrieval=true&useSSL=false";
			String username = "root";
			String password = "root";
			try {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				conn = DriverManager.getConnection(url,username,password);
				return conn;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
}
