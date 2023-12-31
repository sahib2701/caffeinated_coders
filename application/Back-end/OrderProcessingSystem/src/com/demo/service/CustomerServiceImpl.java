package com.demo.service;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.demo.dao.CustomerDao;
import com.demo.dao.CustomerDaoImpl;
import com.demo.beans.Customer;
import com.demo.beans.Order;
import com.demo.exceptions.CustomerNotFoundException;

public class CustomerServiceImpl implements CustomerService{
	// Customer Dao object
	private CustomerDao customerDao;
	
	// Default constructor
	public CustomerServiceImpl() {
		customerDao = new CustomerDaoImpl();
	}

	@Override
	public Customer loginCustomer(String name_or_id, String password) throws SQLException, CustomerNotFoundException {
		try{
			// Check if id
			int cust_id = Integer.parseInt(name_or_id);
			return customerDao.loginUsingId(cust_id, password);
		} catch(NumberFormatException e) {
			// If name
			return customerDao.loginUsingName(name_or_id, password);
		}
	}
	
	@Override
	public Customer getCustomerById(int id) throws SQLException, CustomerNotFoundException {
		return customerDao.getCustomerById(id);
	}
	
	@Override
	public Customer getCustomerByIdOrName(String idOrName) throws SQLException, CustomerNotFoundException {
		try{
			// Check if id
			int cust_id = Integer.parseInt(idOrName);
			return customerDao.getCustomerById(cust_id);
		} catch(NumberFormatException e) {
			// If name
			return customerDao.getCustomerByName(idOrName);
		}
	}
}
