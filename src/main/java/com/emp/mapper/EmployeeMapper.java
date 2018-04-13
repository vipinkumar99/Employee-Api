package com.emp.mapper;

import java.util.ArrayList;
import java.util.List;

import com.emp.model.Employee;
import com.emp.request.dto.AddEmployeeRequestDto;
import com.emp.request.dto.UpdateEmployeeRequestDto;
import com.emp.response.dto.EmployeeResponseDto;
import com.emp.utils.DateUtils;

public class EmployeeMapper {

	public static List<EmployeeResponseDto> convertEntityListToResponseList(List<Employee> employeeList) {
		if (employeeList == null)
			return null;
		List<EmployeeResponseDto> responseList = new ArrayList<EmployeeResponseDto>(employeeList.size());
		for (Employee employee : employeeList)
			responseList.add(convertEntityToResponse(employee));
		return responseList;
	}

	public static EmployeeResponseDto convertEntityToResponse(Employee employee) {
		if (employee == null)
			return null;
		EmployeeResponseDto response = new EmployeeResponseDto();
		response.setEmId(employee.getEmployeeId());
		response.setEmName(employee.getEmployeeName());
		response.setEmAge(employee.getEmployeeAge());
		response.setRoleId(employee.getRoleId());
		response.setCreateDate(DateUtils.dateConversion(employee.getCreated(), DateUtils.FIRST_DATE_FORMAT));
		response.setUpdateDate(DateUtils.dateConversion(employee.getUpdated(), DateUtils.FIRST_DATE_FORMAT));
		return response;

	}

	public static Employee convertAddRequestToEntity(AddEmployeeRequestDto request) {
		if (request == null)
			return null;
		Employee response = new Employee();
		response.setEmployeeName(request.getEmName());
		response.setEmployeeAge(request.getEmAge());
		response.setRoleId(request.getRoleId());
		return response;
	}

	public static Employee convertUpdateRequestToEntity(UpdateEmployeeRequestDto request) {
		if (request == null)
			return null;

		Employee response = new Employee();
		response.setEmployeeId(request.getEmId());
		response.setEmployeeName(request.getEmName());
		response.setEmployeeAge(request.getEmAge());
		response.setRoleId(request.getRoleId());
		return response;
	}

}
