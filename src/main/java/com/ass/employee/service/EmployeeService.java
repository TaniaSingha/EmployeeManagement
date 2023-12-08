package com.ass.employee.service;

import java.util.List;

import com.ass.employee.dto.EmployeeDto;
import com.ass.employee.entity.Employee;
import com.ass.employee.exception.employeeIdNotFoundException;

public interface EmployeeService 
{
	public Employee saveEmployee(EmployeeDto dto);
	
	public List<Employee> getAllEmployee();
	
	public List<Employee> getEmployeeById(long id) throws employeeIdNotFoundException;
	
	public List <Employee> updateEmployee(long id, EmployeeDto dto) throws employeeIdNotFoundException;
	
	public String deleteEmployeeById(long id) throws employeeIdNotFoundException;

}
