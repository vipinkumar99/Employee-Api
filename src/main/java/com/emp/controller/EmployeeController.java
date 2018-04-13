package com.emp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emp.constants.PathMapping;
import com.emp.enums.ResponseCode;
import com.emp.exception.MyException;
import com.emp.request.dto.AddEmployeeRequestDto;
import com.emp.request.dto.UpdateEmployeeRequestDto;
import com.emp.response.BaseResponse;
import com.emp.response.dto.EmployeeResponseDto;
import com.emp.service.IEmployeeService;
import com.emp.validator.EmployeeValidator;

@Controller
@RequestMapping(value = PathMapping.EmployeeMapping.Base)
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@RequestMapping(path = PathMapping.All, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<List<EmployeeResponseDto>> getAllEmployee() throws Exception {
		List<EmployeeResponseDto> response = employeeService.getAllEmployeeList();
		if (CollectionUtils.isEmpty(response)) {
			return new BaseResponse<>(false, null, ResponseCode.NO_EMPLOYEE_PRESENT);
		}
		// System.out.println(response);
		return new BaseResponse<List<EmployeeResponseDto>>(false, response, ResponseCode.OK);
	}

	@RequestMapping(path = PathMapping.NAME_PARAM, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<List<EmployeeResponseDto>> getEmployeeByName(@PathVariable(PathMapping.NAME) String name)
			throws Exception {
		List<EmployeeResponseDto> response = employeeService.getEmployeeByName(name);
		if (CollectionUtils.isEmpty(response)) {
			return new BaseResponse<>(false, null, ResponseCode.NO_EMPLOYEE_PRESENT);
		}
		return new BaseResponse<List<EmployeeResponseDto>>(false, response, ResponseCode.OK);

	}

	@RequestMapping(path = PathMapping.SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<EmployeeResponseDto> saveEmployee(@Valid @RequestBody AddEmployeeRequestDto request)
			throws Exception {
		EmployeeValidator.addEmployeeRequestDtoValidator(request);
		EmployeeResponseDto response = employeeService.saveEmployee(request);
		if (response == null) {
			throw new MyException(ResponseCode.ERROR);

		}
		return new BaseResponse<EmployeeResponseDto>(false, response, ResponseCode.OK);

	}

	@RequestMapping(path = PathMapping.ID_PARAM, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<EmployeeResponseDto> getEmployeeById(@PathVariable(PathMapping.ID) int id) throws Exception {
		EmployeeResponseDto response = employeeService.getEmployeeById(id);
		if (response == null) {
			return new BaseResponse<>(false, null, ResponseCode.NO_EMPLOYEE_PRESENT);
		}
		return new BaseResponse<EmployeeResponseDto>(false, response, ResponseCode.OK);

	}

	@RequestMapping(path = PathMapping.UDATE, method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<EmployeeResponseDto> updateEmployee(@RequestBody UpdateEmployeeRequestDto request)
			throws Exception {
		EmployeeValidator.addEmployeeRequestDtoValidator(request);
		EmployeeResponseDto response = employeeService.updateEmployee(request);
		if (response == null) {
			return new BaseResponse<>(false, null, ResponseCode.NO_EMPLOYEE_PRESENT);
		}
		return new BaseResponse<EmployeeResponseDto>(false, response, ResponseCode.OK);
	}

	@RequestMapping(path = PathMapping.ID_PARAM, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<EmployeeResponseDto> deleteEmployeeById(@PathVariable(PathMapping.ID) int id) throws Exception {

		if (!employeeService.deleteEmployee(id)) {
			return new BaseResponse<>(false, null, ResponseCode.NO_EMPLOYEE_PRESENT);
		}
		return new BaseResponse<EmployeeResponseDto>(false, null, ResponseCode.OK);

	}

}
