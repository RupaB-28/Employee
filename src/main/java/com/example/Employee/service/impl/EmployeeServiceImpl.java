package com.example.Employee.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Employee.dto.EmployeeDto;
import com.example.Employee.entity.Employee;
import com.example.Employee.exception.ResourceNotFoundException;
import com.example.Employee.mapper.EmployeeMapper;
import com.example.Employee.repo.EmployeeRepository;
import com.example.Employee.service.EmployeeService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.maptoEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeByID(long id) {
		Employee emp = null;
		try {
			emp = employeeRepository.findById(id).orElseThrow(
					()-> new ResourceNotFoundException("The emp does not exist with given ID "+id));
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EmployeeMapper.mapToEmployeeDto(emp);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> allEmployees = employeeRepository.findAll();
		return allEmployees.stream().map(emp -> EmployeeMapper.mapToEmployeeDto(emp))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(long empId,EmployeeDto employeeDto) {
		Employee updatedEmpl = null;
		try {
			Employee employee = employeeRepository.findById(empId).orElseThrow(() ->
					new ResourceNotFoundException("The emp does not exist with given ID "+empId));
			employee.setFirstName(employeeDto.getFirstName());
			employee.setLastName(employeeDto.getLastName());
			employee.setEmail(employeeDto.getEmail());
			updatedEmpl = employeeRepository.save(employee);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EmployeeMapper.mapToEmployeeDto(updatedEmpl);
	}

}
