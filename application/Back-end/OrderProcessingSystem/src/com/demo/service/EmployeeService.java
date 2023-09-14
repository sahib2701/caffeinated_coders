package com.demo.service;

import java.sql.SQLException;

import java.util.List;

import com.demo.beans.Employee;
import com.demo.beans.Order;
import com.demo.exceptions.EmployeeNotFoundException;

public interface EmployeeService {
	Employee loginEmployee(int eid, String password) throws SQLException, EmployeeNotFoundException;
}
