package com.techpalle.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.CustomerDao;
import com.techpalle.model.Customer;


@WebServlet("/")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
     String path=request.getServletPath();
		switch(path) 
		{
		case "/edit":
			displayEditPage(request,response);
			break;
		case "/insert":
			insertCustomer(request,response);
			break;
			
		case "/update":
			updateCustomer(request,response);
			break;
		case "/delete":
			deleteCustomer(request,response);
			break;
			
		case "/new":
			displayFormPage(request,response);
			break;
		default:
			getStartUpPage(request,response);
			break;
		}
	}

	
	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		int id=Integer.parseInt(request.getParameter("id"));
		
		
		try {
			
			CustomerDao.deleteCustomer(id);
			response.sendRedirect(request.getContextPath() +"/list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
		
		String n=request.getParameter("tbName");
		String e=request.getParameter("tbEmail");
		
		long m=Long.parseLong(request.getParameter("tbMobile"));
		
		int id=Integer.parseInt(request.getParameter("tbId"));
		
		//Store the above value in User object
			Customer c = new Customer(id,n,e,m);
				
		//Call the method present in DAO layer with above input:
			CustomerDao.updateCustomer(c);
			
			try {
				
				//Redirect customer to customer-list.jsp
				response.sendRedirect(request.getContextPath() +"/list");
			   }
			     catch (IOException e1)
			   {
				
				e1.printStackTrace();
			  }
			
	}


	private void displayEditPage(HttpServletRequest request, HttpServletResponse response) {
		//Read the id value from url:
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		//call the method present in DAO
		Customer customer=CustomerDao.getCustomerById(id);
		
		//Send the above user details to form page:
		request.setAttribute("customer", customer);
		
		
		try {
			//Redirecting to the user-form.jsp:
			RequestDispatcher rd=request.getRequestDispatcher("customer-form.jsp");
			rd.forward(request, response);
		}
		catch (ServletException e)
		{
			
			e.printStackTrace();
			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
	}


	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) {
		//Read customer data
		String n=request.getParameter("tbName");
		String e=request.getParameter("tbEmail");
		
		long m=Long.parseLong(request.getParameter("tbMobile"));
		//Store the above data in user object:
		
		Customer c=new Customer(n,e,m);
		
		//Send the above object as a input for insertUser method present in UserDao
		
		CustomerDao.insertCustomer(c);
		
		try {
			
			//Redirect customer to customer-list.jsp
			response.sendRedirect(request.getContextPath() +"/list");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}


	private void displayFormPage(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			RequestDispatcher rd=request.getRequestDispatcher("customer-form.jsp");
			rd.forward(request, response);
		}
		catch (ServletException e)
		{
			
			e.printStackTrace();
			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	
		
	}


	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) {
		
		
		try {
			
			ArrayList<Customer> al=CustomerDao.getAllCustomer();
			//send collection or data into jsp file
			request.setAttribute("listCustomer", al);
		
			//Code for redirecting user to the startup Page [customer-list.jsp] it is related to the code which is giving exception
			RequestDispatcher rd=request.getRequestDispatcher("customer-list.jsp");
			rd.forward(request, response);
		
		} catch (ServletException e)
		
		{	
			e.printStackTrace();
		} catch (IOException e)
		
		{
			
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
