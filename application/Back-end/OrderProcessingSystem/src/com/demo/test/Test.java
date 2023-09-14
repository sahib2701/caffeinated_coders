package com.demo.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.demo.exceptions.CustomerNotFoundException;
import com.demo.exceptions.InvoiceNotFoundException;
import com.demo.exceptions.OrderNotFoundException;
import com.demo.service.*;

public class Test {
  public static void main(String[] args) {
	System.out.println("Welcome to ORDER PROCESSISING SYSTEM");
	Scanner sc=new Scanner(System.in);
	int choice = 0;
	int empchoice=0;
	int cuschoice=0;
	OrderService orderService=new OrderServiceImpl();
	CustomerService customerService=new CustomerServiceImpl();
	InvoiceService invoiceService=new InvoiceServiceImpl();
	
	do {
		
		System.out.println("Please enter 1.For Employee \n 2.For Customer \n 3.To exit");
		choice=sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Welcome to EMPLOYEE SYSTEM");
			do {
				System.out.println("Please enter 1.To see all orders  \n 2.Approve order \n 3.Add Qoute \n 4.Get Customer's Products \n 5.To Import Products \n 6.Exit");
				empchoice=sc.nextInt();
				switch(empchoice) {
				case 1:
					System.out.println("Please find the list of all orders below:");
					try {
						orderService.getAllOrders();
					} catch (SQLException e) {
						System.out.println("No orders found");
					}
					break;
				case 2:
					System.out.println("Please enter order ID to approve");
					int orderId;
					orderId=sc.nextInt();
					try {
						orderService.approveOrder(orderId);
						System.out.println("Order Successfully Approved");
					} catch (SQLException e) {
						System.out.println("Order Could Not Be Approved");
						
					}
					break;
				case 3:
					System.out.println("Please enter details to add new Quote ");
					 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

				        System.out.print("Enter the date (yyyy-MM-dd): ");
				        String inputDateStr = sc.nextLine();
				        Date order_date = null;

					try {
						order_date = dateFormat.parse(inputDateStr);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						System.out.println("Please try again");
					}
					
					System.out.println("Please enter Customer Id ");
					int customer_id=sc.nextInt();
					System.out.println("Enter customer Shipping Address");
					String customer_shipping_address=sc.next();
					
					System.out.println("Enter total order value");
					float total_order_value=sc.nextFloat();
					System.out.println("Enter customer Shipping Cost");
					float shipping_cost=sc.nextFloat();
					

                    try {
						int status =orderService.addQuote(order_date,customer_id, customer_shipping_address, total_order_value,
							shipping_cost);
						if(status==1)
						{
							System.out.println("Quote added Successfully");
						}
						else {
							System.out.println("Qoute addition couldn't be done");
						}
					} catch (SQLException e) {
						System.out.println("Exception occured");
					}
					break;
				case 4: 
					System.out.println("Please Enter Customer Id for which you want to see Products");
					int customerId =sc.nextInt();
					try {
						orderService.getOrdersByCustomerId(customerId);
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("Customer not found");
					}
					break;
				case 5:
					System.out.println("Please enter order Id for which you want to see the Products");
					orderId = sc.nextInt();
					try {
						orderService.getProducts(orderId);
					} catch (SQLException e) {
						System.out.println("Order Id not found");
						
					}
					break;
				case 6:
					System.out.println("Exiting out of Employee system.Thanks for visiting");
					
				
				}
			}
			while (empchoice!=6);
			
			break;
		case 2:
			System.out.println("WELCOME CUSTOMER :)");
			do {
				System.out.println("Please enter 1.Login   \n 2.Get all your orders \n 3.Get your invoice  \n 4.Get Your Details \n 5.To Approve Order \n 6.Exit");
				cuschoice=sc.nextInt();
				switch(cuschoice) {
				case 1:
					System.out.println("Please enter your Username");
					String nm=sc.next();
					System.out.println("Please enter your password");
					String ps=sc.next();
					try {
						customerService.loginCustomer(nm,ps);
						System.out.println("Login Successful");
					} catch (SQLException e) {
						System.out.println("Login Failed");
					} catch (CustomerNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println("Not Customer with this Username or Id found");
					}
					break;
				case 2:
					System.out.println("Please enter your Id");
					int orderId=sc.nextInt();
					try {
						orderService.getOrderById(orderId);
					} catch (SQLException e) {
						System.out.println("Error occured");
					} catch (OrderNotFoundException e) {
						System.out.println("No order with this Id found");
					}
					break;
				case 3:
					System.out.println("Please enter your order Id");
					orderId=sc.nextInt();
					try {
						invoiceService.getInvoiceByOrderId(orderId);
					} catch (SQLException e) {
						System.out.println("Erorr occured");
					} catch (InvoiceNotFoundException e) {
						System.out.println("No invoice with this order Id exists ");
					}
					break;
				case 4:
					System.out.println("Please enter 1 if you want to see your details by your name and 2 if you want to see your details by Id");
					int s=sc.nextInt();
					if(s==1)
					{   System.out.println("Please enter your name");
					    String ps1=sc.next();
						try {
							customerService.getCustomerByIdOrName(ps1);
						} catch (SQLException e) {
							System.out.println("Erorr occured");
						} catch (CustomerNotFoundException e) {
							// TODO Auto-generated catch block
							System.out.println("No customer with this name exists ");
						}
					}
					else if (s==2)
					{
						System.out.println("Please enter your Id");
					    int id1=sc.nextInt();
						try {
							customerService.getCustomerById(id1);
						} catch (SQLException e) {
							System.out.println("Erorr occured");
						} catch (CustomerNotFoundException e) {
							// TODO Auto-generated catch block
							System.out.println("No customer with this id exists ");
						}
					}
					break;
				case 5:
					System.out.println("Please enter order ID to approve");
					
					orderId=sc.nextInt();
					try {
						orderService.approveOrder(orderId);
						System.out.println("Order Successfully Approved");
					} catch (SQLException e) {
						System.out.println("Order Could Not Be Approved");
						
					}
					break;
				case 6:
					System.out.println("Exiting out of Customer's system.Thanks for visiting");
					
				
				}
			}
			while (cuschoice!=6);
			
			break;
		
		
		case 3:
			//System.exit(0);
			System.out.println("Thank you for using system, Visit again.....");
		
		}
		
	}while (choice!=3);
}

}
