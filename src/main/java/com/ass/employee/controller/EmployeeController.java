package com.ass.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ass.employee.dto.EmployeeDto;
import com.ass.employee.dto.EmployeeResponseDto;
import com.ass.employee.entity.Employee;
import com.ass.employee.exception.employeeIdNotFoundException;
import com.ass.employee.service.EmployeeServiceImpl;





/**

 * <p>Handles HTTP requests to perform CRUD operations on employee.
 * Endpoints include methods to save, retrieve, update, and delete employees.</p>
 *   @author Tania Singha
 */

@RestController
public class EmployeeController 
{

	@Autowired
	private EmployeeServiceImpl service;
	
	
	 /**
     * Saves a new employee.
     *
     * @param dto The DTO containing employee details.
     * @return returns the response entity with the saved employee details.
     */
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<EmployeeResponseDto> saveEmployee(@RequestBody  @Valid EmployeeDto dto) 
	{
		 Employee savedEmployee = service.saveEmployee(dto);
	        return ResponseEntity.status(HttpStatus.CREATED)
	            .body(new EmployeeResponseDto(HttpStatus.CREATED.value(), "Success", "Employee saved successfully", savedEmployee));
	} 
	
	
	/**
     * Retrieves all employees.
     *
     * @return returns all employees details.
     */
	
	@GetMapping("/getAllEmployee")
	public ResponseEntity<EmployeeResponseDto>getAllEmployee() 
	{
		List<Employee> employees = service.getAllEmployee();
        return ResponseEntity.ok(new EmployeeResponseDto(HttpStatus.OK.value(), "Success", "All employees retrieved", employees));
    
		
	}
	
	
	/**
     * Retrieves an employee by ID.
     *
     * @param id The ID of the employee.
     * @return returns the employee details belonging to the specific id
     */
	
	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable("id") long id) 
	{
		try 
		{
            List<Employee> employee = service.getEmployeeById(id);
            return ResponseEntity.ok(new EmployeeResponseDto(HttpStatus.OK.value(), "Success", "Employee found", employee));
        } 
		
		catch (employeeIdNotFoundException e) 
		{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new EmployeeResponseDto(HttpStatus.NOT_FOUND.value(), "Error", e.getMessage(), null));
        }
	}
	
	
	
	 /**
     * Updates an employee by ID.
     *
     * @param id  The ID of the employee to be updated.
     * @param dto The DTO containing updated employee details.
     * @return returns the updated employee details.
     */
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<EmployeeResponseDto> updateEmployee(@PathVariable("id") long id, @RequestBody @Valid EmployeeDto dto) 
	{
		try 
		{
            List<Employee> updatedEmployee = service.updateEmployee(id, dto);
            return ResponseEntity.ok(new EmployeeResponseDto(HttpStatus.OK.value(), "Success", "Employee updated successfully", updatedEmployee));
        } 
		
		catch (employeeIdNotFoundException e) 
		{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new EmployeeResponseDto(HttpStatus.NOT_FOUND.value(), "Error", e.getMessage(), null));
        }
	}
	
	 /**
     * Deletes an employee by ID.
     *
     * @param id The ID of the employee to be deleted.
     * @return returns the deleted employee details.
     */
	
	@DeleteMapping("/deleteEmployeeById/{id}")
	public ResponseEntity<EmployeeResponseDto> deleteEmployeeById(@PathVariable("id") long id) 
	{
		 try 
		 {
	            String message = service.deleteEmployeeById(id);
	            return ResponseEntity.ok(new EmployeeResponseDto(HttpStatus.OK.value(), "Success", message, null));
	        } 
		 catch (employeeIdNotFoundException e) 
		 {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body(new EmployeeResponseDto(HttpStatus.NOT_FOUND.value(), "Error", e.getMessage(), null));
	        }
		
	}
	
	
}
