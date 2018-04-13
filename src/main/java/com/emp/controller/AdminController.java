package com.emp.controller;

import java.util.List;

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
import com.emp.request.dto.AddAdminRequestDto;
import com.emp.request.dto.AdminLoginRequestDto;
import com.emp.request.dto.UpdateAdminRequestDto;
import com.emp.response.BaseResponse;
import com.emp.response.dto.AdminResponseDto;
import com.emp.service.IAdminService;
import com.emp.validator.AdminLoginValidator;
import com.emp.validator.AdminValidator;

@Controller
@RequestMapping(PathMapping.AdminMapping.Base)
public class AdminController {

	@Autowired
	private IAdminService adminService;

	@RequestMapping(path = PathMapping.All, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<List<AdminResponseDto>> getAll() throws Exception {
		List<AdminResponseDto> response = adminService.getAll();
		if (CollectionUtils.isEmpty(response)) {
			return new BaseResponse<>(false, null, ResponseCode.NO_ADMIN_PRESENT);
		}
		return new BaseResponse<List<AdminResponseDto>>(false, response, ResponseCode.OK);
	}

	@RequestMapping(path = PathMapping.SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<AdminResponseDto> save(@RequestBody AddAdminRequestDto request) throws Exception {
		AdminValidator.adminRequestValidator(request);
		AdminResponseDto response = adminService.save(request);
		if (response == null) {
			throw new MyException(ResponseCode.ERROR);
		}
		return new BaseResponse<AdminResponseDto>(false, response, ResponseCode.OK);
	}

	/* update */
	@RequestMapping(path = PathMapping.UDATE, method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<AdminResponseDto> update(@RequestBody UpdateAdminRequestDto request) throws Exception {
		AdminResponseDto response = adminService.update(request);
		if (response == null)
			throw new MyException(ResponseCode.ERROR);
		return new BaseResponse<AdminResponseDto>(false, response, ResponseCode.OK);
	}

	/* get by id */
	@RequestMapping(path = PathMapping.ID_PARAM, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<AdminResponseDto> getById(@PathVariable(PathMapping.ID) int id) throws Exception {
		AdminResponseDto response = adminService.getById(id);
		if (response == null) {
			return new BaseResponse<>(false, null, ResponseCode.NO_ADMIN_PRESENT);
		}

		return new BaseResponse<AdminResponseDto>(false, response, ResponseCode.OK);
	}

	/* delete by id */
	@RequestMapping(path = PathMapping.ID_PARAM, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<AdminResponseDto> deleteById(@PathVariable(PathMapping.ID) int id) throws Exception {

		if (!adminService.delete(id)) {
			return new BaseResponse<>(false, null, ResponseCode.NO_ADMIN_PRESENT);
		}
		return new BaseResponse<AdminResponseDto>(false, null, ResponseCode.OK);

	}

	/* login */
	@RequestMapping(path = PathMapping.LOGIN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<AdminResponseDto> login(@RequestBody AdminLoginRequestDto request) throws Exception {
		AdminLoginValidator.adminLoginValidator(request);
		if (!adminService.login(request)) {
			return new BaseResponse<>(false, null, ResponseCode.NO_USER_PRESENT);
		}
		return new BaseResponse<AdminResponseDto>(false, null, ResponseCode.OK);
	}

	/* password */
	@RequestMapping(path = PathMapping.PASSWORD, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<AdminResponseDto> changePassword(@RequestBody AdminLoginRequestDto request) throws Exception {
		//AdminLoginValidator.adminLoginValidator(request);
		if (!adminService.passwordChange(request)) {
			return new BaseResponse<>(false, null, ResponseCode.NO_USER_PRESENT);
		}
		return new BaseResponse<AdminResponseDto>(false, null, ResponseCode.OK);
	}

	
}
