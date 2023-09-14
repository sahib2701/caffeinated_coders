package com.demo.dao;

import java.sql.SQLException;

import java.util.List;

import com.demo.beans.Customer;
import com.demo.beans.Order;
import com.demo.exceptions.CustomerNotFoundException;

public interface CustomerDao {
	Customer getCustomerById(int id) throws SQLException, CustomerNotFoundException;
	Customer getCustomerByName(String name) throws SQLException, CustomerNotFoundException;
	Customer loginUsingId(int id, String password) throws SQLException, CustomerNotFoundException;
	Customer loginUsingName(String name, String password) throws SQLException, CustomerNotFoundException;
}
