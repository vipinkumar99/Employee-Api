package com.emp.service;

import java.util.List;

import com.emp.exception.MyException;
import com.emp.request.dto.AddEmployeeRequestDto;
import com.emp.request.dto.UpdateEmployeeRequestDto;
import com.emp.response.dto.EmployeeResponseDto; 

public interface IEmployeeService {

	public List<EmployeeResponseDto> getAllEmployeeList();
	public EmployeeResponseDto getEmployeeById(int id);
	public List<EmployeeResponseDto> getEmployeeByName(String name);
	public EmployeeResponseDto saveEmployee(AddEmployeeRequestDto employee)throws MyException;
	public EmployeeResponseDto  updateEmployee(UpdateEmployeeRequestDto employee)throws MyException;
	public boolean deleteEmployee(int id);
}
