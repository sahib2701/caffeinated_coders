package com.demo.service;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;
import com.demo.beans.Employee;
import com.demo.beans.Order;
import com.demo.exceptions.EmployeeNotFoundException;

public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDao employeeDao;
	
	// Default constructor
	public EmployeeServiceImpl() {
		employeeDao = new EmployeeDaoImpl();
	}
	
	@Override
	public Employee loginEmployee(int eid, String password) throws SQLException, EmployeeNotFoundException {
		return employeeDao.loginUsingId(eid, password);
	}
}
