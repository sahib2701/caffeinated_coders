package com.demo.service;

import java.sql.SQLException;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Type;


import com.demo.dao.CustomerDao;
import com.demo.dao.CustomerDaoImpl;
import com.demo.dao.OrderDao;
import com.demo.dao.OrderDaoImpl;
import com.demo.beans.Order;
import com.demo.beans.Product;
import com.demo.exceptions.OrderNotFoundException;

public class OrderServiceImpl implements OrderService{
	// Order Dao object
	private OrderDao orderDao;
	
	// Default constructor
	public OrderServiceImpl() {
		orderDao = new OrderDaoImpl();
	}
	@Override
	public List<Order> getAllOrders() throws SQLException {
		return orderDao.getAllOrdersWithoutProductList();
	}

	@Override
	public List<Order> getOrdersByCustomerId(int customerId) throws SQLException {
		return orderDao.getOrdersWithoutProductListByCustomerId(customerId);
	}

	@Override
	public List<Order> getQuotesByCustomerId(int customerId) throws SQLException {
		return orderDao.getQuotesWithoutProductListByCustomerId(customerId);
	}
	
	@Override
	public Order getOrderById(int orderId) throws SQLException, OrderNotFoundException {
		return orderDao.getOrderByOrderId(orderId);
	}
	
	@Override
	public Map<Product, Integer> getProducts(int orderId) throws SQLException {
		return orderDao.getOrderHasProducts(orderId);
	}
	
	@Override
	public void approveOrder(int orderId) throws SQLException {
		orderDao.approveOrder(orderId);
	}
	
	@Override
	public int addQuote(Date order_date, int customer_id, String customer_shipping_address, float total_order_value,
			float shipping_cost) throws SQLException {
				return orderDao.addQuote(order_date, customer_id, customer_shipping_address, total_order_value, shipping_cost);
		
	}
	
	
	@Override
	public void expireOrder(int orderId) throws SQLException {
		orderDao.expireOrder(orderId);
	}
}
