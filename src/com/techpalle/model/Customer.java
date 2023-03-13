package com.techpalle.model;

public class Customer {
	
	private int id;
	private String name;
	private String email;
	private long mobile;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	//update operation and Display or Read operation
	public Customer(int id, String name, String email, long mobile) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}
	//insert operation
	public Customer(String name, String email, long mobile) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}
	
	//For doing delete operation we don't need any operation
	

}
