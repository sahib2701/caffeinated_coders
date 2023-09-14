package com.demo.service;

import java.sql.SQLException;

import java.util.List;

import com.demo.beans.Customer;
import com.demo.beans.Order;
import com.demo.exceptions.CustomerNotFoundException;

public interface CustomerService {
	
	Customer loginCustomer(String name_or_id, String password) throws SQLException, CustomerNotFoundException;

	Customer getCustomerById(int id) throws SQLException, CustomerNotFoundException;

	Customer getCustomerByIdOrName(String idOrName) throws SQLException, CustomerNotFoundException;
}
