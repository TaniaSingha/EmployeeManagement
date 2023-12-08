package com.ass.employee.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ass.employee.dto.EmployeeDto;
import com.ass.employee.entity.Employee;
import com.ass.employee.exception.employeeIdNotFoundException;
import com.ass.employee.repository.EmployeeRepository;
import com.ass.employee.service.EmployeeServiceImpl;

public class EmployeeServiceImplTest 
{
	@Mock
	private EmployeeRepository repository;
	
	@InjectMocks
	private EmployeeServiceImpl service;
	
	 /**
     * Initializes mock objects before each test.
     */
	
	 @BeforeEach
	    public void setUp() 
	 {
	        MockitoAnnotations.initMocks(this);
	    }
	 
	 
	 
	 /**
	     * Test case to verify the saveEmployee method.
	     */
	   @Test
	    public void testSaveEmployee() 
	 {
	        EmployeeDto employeeDto = new EmployeeDto();
	        employeeDto.setName("John");
	        

	        Employee employee = new Employee();
	        employee.setName(employeeDto.getName());
	       

	        when(repository.save(any(Employee.class))).thenReturn(employee);

	        Employee savedEmployee = service.saveEmployee(employeeDto);

	        assertEquals(employee.getName(), savedEmployee.getName());
	        
	    }
	   
	   
	   /**
	     * <p>Test case to verify the getAllEmployee method.</p>
	     * 
	     * This method verifies if all employees are retrieved successfully.
	     */
	   
	   @Test
	    public void testGetAllEmployee() 
	   {
	        List<Employee> employees = new ArrayList<>();
	        
	        when(repository.findAll()).thenReturn(employees);

	        List<Employee> retrievedEmployees = service.getAllEmployee();

	        assertEquals(employees.size(), retrievedEmployees.size());
	        
	    }
	   


	   /**
	     * Test case to verify the getEmployeeById method.
	     * 
	     * This method verifies if an employee is retrieved by their ID.
	     * @throws employeeIdNotFoundException If the employee ID is not found.
	     */
	   
	   @Test
	    public void testGetEmployeeById() throws employeeIdNotFoundException 
	   {
	        long id = 1L;
	        Employee employee = new Employee();
	       

	        Optional<Employee> optionalEmployee = Optional.of(employee);

	        when(repository.findById(id)).thenReturn(optionalEmployee);

	        List<Employee> retrievedEmployee = service.getEmployeeById(id);

	        assertEquals(1, retrievedEmployee.size());
	        
	    }
	   
	   
	   
	   /**
	     * Test case to verify the updateEmployee method.
	     * 
	     * This method verifies if an employee's details are updated successfully.
	     * @throws employeeIdNotFoundException If the employee ID is not found.
	     */
	   
	   @Test
	    public void testUpdateEmployee() throws employeeIdNotFoundException 
	   {
	        long id = 1L;
	        EmployeeDto employeeDto = new EmployeeDto();
	        employeeDto.setName("Updated Name");
	     

	        Employee existingEmployee = new Employee();
	       

	        Optional<Employee> optionalEmployee = Optional.of(existingEmployee);

	        when(repository.findById(id)).thenReturn(optionalEmployee);
	        when(repository.save(any(Employee.class))).thenReturn(existingEmployee);

	        List<Employee> updatedEmployee = service.updateEmployee(id, employeeDto);

	        assertEquals(1, updatedEmployee.size());
	        assertEquals(employeeDto.getName(), updatedEmployee.get(0).getName());
	       
	    }
	   
	   
	   
	   /**
	     * Test case to verify the deleteEmployeeById method.
	     * 
	     * This method verifies if an employee is deleted successfully by their ID.
	     * @throws employeeIdNotFoundException If the employee ID is not found.
	     */
	   
	   @Test
	    public void testDeleteEmployeeById() throws employeeIdNotFoundException 
	   {
		   long id = 1L;

		    when(repository.existsById(id)).thenReturn(true);

		    String deletionMessage = service.deleteEmployeeById(id);

		    String expectedMessage = "Employee with ID " + id + " has been deleted.";
		   
		    String normalizedExpected = expectedMessage.replaceAll("\\s", "");
		    String normalizedActual = deletionMessage.replaceAll("\\s", "");

		    assertEquals(normalizedExpected, normalizedActual);
	    }

	   
	   
	

}
