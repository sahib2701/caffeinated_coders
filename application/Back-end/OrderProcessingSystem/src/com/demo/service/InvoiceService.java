package com.demo.service;

import java.sql.SQLException;

import java.util.Date;

import com.demo.beans.Invoice;
import com.demo.beans.Order;
import com.demo.exceptions.InvoiceNotFoundException;
import com.demo.util.GSTType;
import com.demo.util.InvoiceStatus;

public interface InvoiceService {
	
		Invoice getInvoiceByOrderId(int orderId) throws SQLException, InvoiceNotFoundException;
		
		
		void addInvoice(Date invoiceDate, int order_id, int customer_id, GSTType gst_type, float total_value, InvoiceStatus status) throws SQLException;

	}
