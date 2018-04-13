package com.emp.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dao.IEmployeeDao;
import com.emp.enums.ResponseCode;
import com.emp.exception.MyException;
import com.emp.mapper.EmployeeMapper;
import com.emp.model.Employee;
import com.emp.request.dto.AddEmployeeRequestDto;
import com.emp.request.dto.UpdateEmployeeRequestDto;
import com.emp.response.dto.EmployeeResponseDto;
import com.emp.response.dto.RoleResponseDto;
import com.emp.service.IEmployeeService;
import com.emp.service.IRoleService;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeDao employeeDao;

	@Autowired
	IRoleService roleService;

	@Override
	public List<EmployeeResponseDto> getAllEmployeeList() {
		return EmployeeMapper.convertEntityListToResponseList(employeeDao.all());

	}

	@Override
	public EmployeeResponseDto saveEmployee(AddEmployeeRequestDto request) throws MyException {
		Employee employee = EmployeeMapper.convertAddRequestToEntity(request);
		if (employee == null) {
			return null;
		}
		RoleResponseDto response = roleService.getById(employee.getRoleId());
		if (response == null) {
			throw new MyException(ResponseCode.NO_ROLE_PRESENT);
		}
		employeeDao.save(employee);
		return EmployeeMapper.convertEntityToResponse(employee);
	}

	@Override
	public EmployeeResponseDto updateEmployee(UpdateEmployeeRequestDto employee) throws MyException {
		Employee response = EmployeeMapper.convertUpdateRequestToEntity(employee);
		if (response == null) {
			return null;
		}
		Employee entity = employeeDao.getById(response.getEmployeeId());
		if (entity == null) {
			throw new MyException(ResponseCode.NO_EMPLOYEE_PRESENT);
		}
		response.setCreated(entity.getCreated());
		employeeDao.update(response);
		return EmployeeMapper.convertEntityToResponse(response);
	}

	@Override
	public EmployeeResponseDto getEmployeeById(int id) {
		return EmployeeMapper.convertEntityToResponse(employeeDao.getById(id));
	}

	@Override
	public List<EmployeeResponseDto> getEmployeeByName(String name) {
		return EmployeeMapper.convertEntityListToResponseList(employeeDao.viewEmployeeByName(name));
	}

	@Override
	public boolean deleteEmployee(int id) {
		employeeDao.delete(id);
		return true;
	}

}
