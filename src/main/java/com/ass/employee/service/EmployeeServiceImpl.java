package com.ass.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ass.employee.dto.EmployeeDto;
import com.ass.employee.entity.Employee;
import com.ass.employee.exception.employeeIdNotFoundException;
import com.ass.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	
	@Autowired
	private EmployeeRepository repository;
	
	Employee employee= new Employee();

	
	 /**
     * Saves a new employee.
     *
     * @param dto The DTO containing employee details.
     * @return returns the saved employee entity.
     */
	
	
	@Override
	public Employee saveEmployee(EmployeeDto dto) 
	{
		employee.setName(dto.getName());
		employee.setDepartment(dto.getDepartment());
		employee.setDesignation(dto.getDesignation());
		employee.setEmail(dto.getEmail());
		employee.setMobileNo(dto.getMobileNo());
	
		return repository.save(employee);
	}
	
	
	/**
     * Retrieves all employees.
     *
     * @return returns list of all employees.
     */

	@Override
	public List<Employee> getAllEmployee() 
	{
		
		return repository.findAll();
	}
	
	
	
	  /**
     * Retrieves an employee by ID.
     *
     * @param id The ID of the employee.
     * @return List containing the retrieved employee with specific Id.
     * @throws employeeIdNotFoundException If employee with the given ID is not found.
     */
	@Override
	public List<Employee> getEmployeeById(long id) throws employeeIdNotFoundException 
	{
		
		List<Employee> list=new ArrayList<>();
		
		Optional<Employee> optional = repository.findById(id);
		
		optional.ifPresent(employee ->{
			
			employee.getName();
			employee.getDepartment();
			employee.getDesignation();
			employee.getEmail();
			employee.getMobileNo();
			
			list.add(employee);
			
		});
		
		
		if (list.isEmpty())
		{
			throw new employeeIdNotFoundException("Employee with Id" + " "+id + " "+ "not found");
		}
		
		return list;
		
		
	
	}
	
	
	
	/**
     * Updates an employee by ID.
     *
     * @param id  The ID of the employee to be updated.
     * @param dto The DTO containing updated employee details.
     * @return  List containing the updated employee belongs to specific id.
     * @throws employeeIdNotFoundException If employee with the given ID is not found.
     */

	@Override
	public List<Employee> updateEmployee(long id, EmployeeDto dto) throws employeeIdNotFoundException 
	{
         List<Employee> list=new ArrayList<>();
		
		Optional<Employee> optional = repository.findById(id);
		
		optional.ifPresent(employee->{
			
			
			employee.setName(dto.getName());
			employee.setDepartment(dto.getDepartment());
			employee.setDesignation(dto.getDesignation());
			employee.setEmail(dto.getEmail());
			employee.setMobileNo(dto.getMobileNo());
		
			repository.save(employee);
			
			list.add(employee);
			
		});
		
		if (list.isEmpty())
		{
			throw new employeeIdNotFoundException("Employee with Id" + " " + id + " "+ "not found");
		}
		
		return list;
		
	}
	
	
	
	
	 /**
     * Deletes an employee by ID.
     *
     * @param id The ID of the employee to be deleted.
     * @return String Deletion status message.
     * @throws employeeIdNotFoundException If employee with the given ID is not found.
     */

	@Override
	public String deleteEmployeeById(long id) throws employeeIdNotFoundException 
	{
		
		if(repository.existsById(id))
		{
			repository.deleteById(id);
			
			return "Employee with ID " + " " +id + " " +" has been deleted.";
		}
		
		else
		{
			throw new employeeIdNotFoundException("Employee with Id" + " " + id + " "+ "not found");
			
		}
		
		
		
	
		
		
		
		
	}

}
