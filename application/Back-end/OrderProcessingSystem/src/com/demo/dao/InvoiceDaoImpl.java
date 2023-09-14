package com.demo.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.demo.beans.*;
import com.demo.exceptions.InvoiceNotFoundException;
import com.demo.util.GSTType;
import com.demo.util.InvoiceStatus;

public class InvoiceDaoImpl implements InvoiceDao{
	private static Connection conn;
	private static PreparedStatement selectInvoiceByOrderId, insertInvoice;
	
	static {
		conn = DBUtil.getConnection();
		try {
			selectInvoiceByOrderId = conn.prepareStatement("SELECT * FROM tbl_invoice WHERE order_id = ?");
			insertInvoice = conn.prepareStatement("INSERT INTO tbl_invoice (invoice_date, order_id, customer_id, gst_type, total_value, status) VALUES(?,?,?,?,?,?)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Fetch invoice by order id
	@Override
	public Invoice fetchInvoiceByOrderId(int orderId) throws SQLException, InvoiceNotFoundException {
		selectInvoiceByOrderId.setInt(1, orderId);
		ResultSet rs = selectInvoiceByOrderId.executeQuery();
		if(rs.next())
			return(new Invoice(rs.getInt(1),rs.getDate(2),rs.getInt(3),rs.getInt(4),GSTType.valueOf(rs.getString(5)),rs.getFloat(6),InvoiceStatus.valueOf(rs.getString(7))));
		throw new InvoiceNotFoundException("Invoice for given order id not found");
	}
	
	// Add invoice in invoice table
	@Override
	public void addInvoice(Date invoice_date, int order_id, int customer_id, GSTType gst_type, float total_value, InvoiceStatus status) throws SQLException {
		java.sql.Date invoiceDate = new java.sql.Date(invoice_date.getTime());
		insertInvoice.setDate(1, invoiceDate);
		insertInvoice.setInt(2, order_id);
		insertInvoice.setInt(3, customer_id);
		insertInvoice.setString(4, gst_type.toString());
		insertInvoice.setFloat(5, total_value);
		insertInvoice.setString(6, status.toString());
		insertInvoice.executeUpdate();
	}

	
	
	
	
}
