package com.demo.dao;

import java.sql.SQLException;

import java.util.List;

import com.demo.beans.*;

import com.demo.exceptions.*;

public interface EmployeeDao {
	Employee loginUsingId(int id, String password) throws SQLException, EmployeeNotFoundException;
}
