package com.demo.service;

import java.sql.SQLException;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.demo.beans.Order;
import com.demo.beans.Product;
import com.demo.exceptions.OrderNotFoundException;

public interface OrderService {

	List<Order> getAllOrders() throws SQLException;

	List<Order> getOrdersByCustomerId(int customerId) throws SQLException;

	List<Order> getQuotesByCustomerId(int customerId) throws SQLException;

	Order getOrderById(int orderId) throws SQLException, OrderNotFoundException;

	Map<Product, Integer> getProducts(int orderId) throws SQLException;

	void approveOrder(int orderId) throws SQLException;

	int addQuote(Date order_date, int customer_id, String customer_shipping_address, float total_order_value,
			float shipping_cost) throws SQLException;


	void expireOrder(int orderId) throws SQLException;

}
