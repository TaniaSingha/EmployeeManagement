package com.ass.employee.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Employee_Details")
public class Employee implements Serializable
{

	@Id
	@GenericGenerator(name="auto",strategy = "increment")
	@GeneratedValue(generator="auto")
	@Column(name="employee_id")
	private long id;
	
	
	
	@Column(name="employee_name")
	private String name;
	
	
	@Column(name="employee_department")
	
	private String department;
	
	
	@Column(name="employee_designation")
	private String designation;
	
	
	
	
	@Column(name="employee_email")
	
	private String email;


	@Column(name="employee_mobileNo")
	private String mobileNo;


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(long id, String name, String department, String designation, String email, String mobileNo) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.designation = designation;
		this.email = email;
		this.mobileNo = mobileNo;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", designation=" + designation
				+ ", email=" + email + ", mobileNo=" + mobileNo + "]";
	}




	

	
	
}
