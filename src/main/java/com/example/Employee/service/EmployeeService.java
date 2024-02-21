package com.example.Employee.service;

import java.util.List;

import com.example.Employee.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	EmployeeDto getEmployeeByID(long id);
	List<EmployeeDto> getAllEmployees();
	EmployeeDto updateEmployee(long id, EmployeeDto employeeDto);

}
