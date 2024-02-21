package com.example.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.dto.EmployeeDto;
import com.example.Employee.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/hello")
	public String helloAPI() {
		return "Welcome to Employee application !!!!!!!!!!";
	}
	
	@PostMapping("/createEmp")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto)
	{
		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") long empId) {
		EmployeeDto employeeByID = employeeService.getEmployeeByID(empId);
		return ResponseEntity.ok(employeeByID);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
		List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
		return ResponseEntity.ok(allEmployees);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") long empId, 
													@RequestBody EmployeeDto employeeDto) {
		EmployeeDto updatedEmployee = employeeService.updateEmployee(empId, employeeDto);
		return ResponseEntity.ok(updatedEmployee);
	}

}
