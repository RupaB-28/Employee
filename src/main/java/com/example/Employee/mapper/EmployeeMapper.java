package com.example.Employee.mapper;

import com.example.Employee.dto.EmployeeDto;
import com.example.Employee.entity.Employee;

public class EmployeeMapper {
	
	public static Employee maptoEmployee(EmployeeDto employeeDto) {
		return new Employee(
				employeeDto.getId(), 
				employeeDto.getFirstName(),
				employeeDto.getLastName(), 
				employeeDto.getEmail());
	}
	
	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		return new EmployeeDto(
				employee.getId(), 
				employee.getFirstName(),
				employee.getLastName(), 
				employee.getEmail());
	}

}
