package com.demo.rest.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Employee{
	private String name;
	@Id
	private int employeeId;
	public Employee(String name, int employeeId) { 
		this.name = name;
		this.employeeId = employeeId;
	}
	public Employee() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
}
