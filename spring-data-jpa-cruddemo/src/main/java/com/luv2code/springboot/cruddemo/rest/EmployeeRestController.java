package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService  theEmployeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		this.theEmployeeService = theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return theEmployeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee emp = theEmployeeService.findById(employeeId);
		
		if(emp == null) {
			throw new RuntimeException("Employee not found " + employeeId);
		}
		return emp;
	}
	
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee theEmp) {
		
		theEmp.setId(0);
		theEmployeeService.save(theEmp);
		return theEmp;
	}
	
	@PutMapping("/employees")
	public Employee updateEmp(@RequestBody Employee emp) {
		theEmployeeService.save(emp);
		return emp;
	}
	

	@DeleteMapping("/employees/{theId}")
	public String updateEmp(@PathVariable int theId) {
		Employee emp = theEmployeeService.findById(theId);
		
		if(emp == null) {
			throw new RuntimeException("Employee not found " + theId);
		}
		theEmployeeService.delete(theId);
		return "Deleted" + theId;
	}
}
