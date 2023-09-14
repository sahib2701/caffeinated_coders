package com.demo.dao;

import java.util.Date;

import java.sql.SQLException;

import com.demo.beans.*;
import com.demo.exceptions.InvoiceNotFoundException;
import com.demo.util.*;


public interface InvoiceDao {
	Invoice fetchInvoiceByOrderId(int orderId) throws SQLException, InvoiceNotFoundException;
	void addInvoice(Date invoiceDate, int order_id, int customer_id, GSTType gst_type, float total_value, InvoiceStatus status) throws SQLException;
}
