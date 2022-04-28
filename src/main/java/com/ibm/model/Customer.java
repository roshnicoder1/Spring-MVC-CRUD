package com.ibm.model;

import java.time.LocalDateTime;

public class Customer {
	private int custno;
	private String custname;
	private int ordervalue;
	private LocalDateTime createdAt;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int custno, String custname, int ordervalue, LocalDateTime createdAt) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.ordervalue = ordervalue;
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Customer [custno=" + custno + ", custname=" + custname + ", ordervalue=" + ordervalue + ", createdAt="
				+ createdAt + "]";
	}
	public int getCustno() {
		return custno;
	}
	public void setCustno(int custno) {
		this.custno = custno;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public int getOrdervalue() {
		return ordervalue;
	}
	public void setOrdervalue(int ordervalue) {
		this.ordervalue = ordervalue;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	

}
