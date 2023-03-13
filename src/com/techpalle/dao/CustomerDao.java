package com.techpalle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.techpalle.model.Customer;

public class CustomerDao {
	
	private final static String selectAllCustomer="select * from customer";
	private final static String insertCustomer = "insert into customer(name,email,mobile) values(?,?,?)";
	private final static String updateCustomer = "update customer set name=?,email=?,mobile=? where id=?";
	private final static String selectCustomerById = "select * from customer where id = ?";
	private final static String deleteCustomer="delete from customer where id=?";
	
	private final static String url="jdbc:mysql://localhost:3306/customer_management";
	private final static String username="root";	
	private final static String password="Pawan123";
	
	private final static String driverPath ="com.mysql.cj.jdbc.Driver";
	private  static Connection con=null;
	private  static Statement stm=null;
	private  static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	public static Connection getConnectionDef() {
		try {
			Class.forName(driverPath);
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	
	public static Customer getCustomerById(int id)
	{
		Customer c = null;
	
		try {
			con = getConnectionDef();
			
			
			ps=con.prepareStatement(selectCustomerById);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			rs.next();
			String n=rs.getString(2);
			String e=rs.getString(3);
			long m=rs.getLong(4);
			
			c=new Customer(id,n,e,m );
			
		   }
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			   if(rs != null) {
			   
			   try {
				   rs.close();
				   
			     } 
			   catch (SQLException e)
			   {
				e.printStackTrace();
			     }
			   }  
			   if(ps != null) {
				   try {
					ps.close();
				    }
				   catch (SQLException e) 
				   {
					// TODO Auto-generated catch block
					e.printStackTrace();
				  }
			   }
			   
			   if(con != null)
			   {
				   try {
					con.close();
				    }
				   catch (SQLException e) 
				   {
					// TODO Auto-generated catch block
					e.printStackTrace();
				   }
			    }
			   
			   }
		return c;
	}
	
	public static void deleteCustomer(int id) {
		
		//boolean rowDeleted = false;
		try {
			con = getConnectionDef();
			
			ps=con.prepareStatement(deleteCustomer);
			ps.setInt(1, id);
			//rowDeleted=ps.executeUpdate()>0;
			ps.executeUpdate();
			
		   }
		   catch (SQLException e) 
		    {
			
			e.printStackTrace();
		     }
		finally {
			if(ps != null)
			{
				try 
				{
					ps.close();
				} catch (SQLException e) 
				{
				    
				  e.printStackTrace();
				}
			}
			if(con != null) 
			{
				try
				{
					con.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		

	}
	
		
	public static void updateCustomer(Customer customer) {
		try {
			con = getConnectionDef();
			ps=con.prepareStatement(updateCustomer);
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setLong(3, customer.getMobile());
			ps.setInt(4, customer.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			  
			   
			   if(ps != null) 
			   {
				   try
				   {
					ps.close();
				   }
				   catch (SQLException e)
				   {
					// TODO Auto-generated catch block
					e.printStackTrace();
				   }
			   }
			   
			   if(con != null) 
			   {
				   try
				   {
					con.close();
				   }
				   catch (SQLException e)
				   {
					// TODO Auto-generated catch block
					e.printStackTrace();
				  }
			   
			   }
		}
		
	}
	
	public static void insertCustomer(Customer customer) {
		
		try {
			con = getConnectionDef();
			ps=con.prepareStatement(insertCustomer);
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setLong(3, customer.getMobile());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			  
			   
			   if(ps != null) 
			   {
				   try
				   {
					ps.close();
				   }
				   catch (SQLException e)
				   {
					// TODO Auto-generated catch block
					e.printStackTrace();
				   }
			   }
			   
			   if(con != null) 
			   {
				   try
				   {
					con.close();
				   }
				   catch (SQLException e)
				   {
					// TODO Auto-generated catch block
					e.printStackTrace();
				  }
			   
			   }
		}
	}
	
	
	public static ArrayList<Customer>  getAllCustomer(){
		
		  ArrayList<Customer> alu = new ArrayList<Customer>();
		try {
			con = getConnectionDef();
			
			
			stm=con.createStatement();
			 rs=stm.executeQuery(selectAllCustomer);
			
			while(rs.next()) {
				int i=rs.getInt(1);
				String n=rs.getString(2);
				String e=rs.getString(3);
				long m=rs.getLong(4);
				
				Customer u=new Customer(i,n,e,m);
				alu.add(u);
			}
			
		   }
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			   if(rs != null) {
			   
			   try {
				   rs.close();
				   
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			   
			   if(stm != null) {
				   try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }
			   
			   if(con != null) {
				   try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }
		}
		}
		
		return alu;	
	}	
}
