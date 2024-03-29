package com.example.Employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeDto {
	
	private long id;
	private String firstName;
	private String lastName;
	private String email;

}
