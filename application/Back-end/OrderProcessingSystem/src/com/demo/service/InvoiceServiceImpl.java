package com.demo.service;

import java.sql.SQLException;

import java.util.Date;

import com.demo.dao.InvoiceDao;
import com.demo.dao.InvoiceDaoImpl;
import com.demo.beans.Invoice;
import com.demo.beans.Order;
import com.demo.exceptions.InvoiceNotFoundException;
import com.demo.util.GSTType;
import com.demo.util.InvoiceStatus;

public class InvoiceServiceImpl implements InvoiceService{
	private InvoiceDao invoiceDao;
	
	public InvoiceServiceImpl() {
		invoiceDao = new InvoiceDaoImpl();
	}
	
	
	@Override
	public Invoice getInvoiceByOrderId(int orderId) throws  SQLException, InvoiceNotFoundException {
		return invoiceDao.fetchInvoiceByOrderId(orderId);
		 
	}

	@Override
	public void addInvoice(Date invoiceDate, int order_id, int customer_id, GSTType gst_type, float total_value,
			InvoiceStatus status) throws SQLException {
		invoiceDao.addInvoice(invoiceDate, order_id, customer_id, gst_type, total_value, status);
	}

//	public Invoice generateInvoiceService(Order o1) throws NoSuchOrderIdException {
//		// TODO Auto-generated method stub
//		InvoiceDao id1=new InvoiceDaoImpl();
//		return id1.generateInvoiceDao(o1);
//	}
//
//	public Order generateOrderService(Order o1) throws NoSuchOrderIdException {
//		// TODO Auto-generated method stub
//		InvoiceDao id1=new InvoiceDaoImpl();
//		return id1.generateOrderDao(o1);	}

}
