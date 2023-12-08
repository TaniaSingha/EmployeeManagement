package com.ass.employee.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class EmployeeDto implements Serializable
{

	@NotBlank(message="employee name can not be null")
	private String name;
	
	

	@NotBlank
	private String department;
	

	@NotBlank
	private String designation;
	
	
	

	@Email(message="invalid email")
	private String email;



	@Pattern(regexp="^\\d{10}$", message="please enter proper mobile number")
	private String mobileNo;



	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public EmployeeDto(String name, String department,String designation, String email,
			 String mobileNo) {
		super();
		this.name = name;
		this.department = department;
		this.designation = designation;
		this.email = email;
		this.mobileNo = mobileNo;
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

	
	
	
	

}
