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
import com.emp.request.dto.AddRoleRequestDto;
import com.emp.request.dto.UpdateRoleRequestDto;
import com.emp.response.BaseResponse;
import com.emp.response.dto.CategoryResponseDto;
import com.emp.response.dto.RoleResponseDto;
import com.emp.service.IRoleService;
import com.emp.validator.RoleValidator;

@Controller
@RequestMapping(PathMapping.RoleMapping.Base)
public class RoleController {

	@Autowired
	private IRoleService roleService;

	/* get all list */
	@RequestMapping(path = PathMapping.All, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<List<RoleResponseDto>> getRoleList() throws Exception {
		List<RoleResponseDto> response = roleService.getAll();
		if (CollectionUtils.isEmpty(response)) {
			return new BaseResponse<>(false, null, ResponseCode.NO_ROLE_PRESENT);
		}
		return new BaseResponse<List<RoleResponseDto>>(false, response, ResponseCode.OK);
	}

	/* save */
	@RequestMapping(path = PathMapping.SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<RoleResponseDto> saveRole(@RequestBody AddRoleRequestDto request) throws Exception {
		RoleValidator.roleRequestValidator(request);
		RoleResponseDto response = roleService.save(request);
		if (response == null) {
			throw new MyException(ResponseCode.ERROR);
		}
		return new BaseResponse<RoleResponseDto>(false, response, ResponseCode.OK);
	}

	/* update */
	@RequestMapping(path = PathMapping.UDATE, method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<RoleResponseDto> updateRole(@RequestBody UpdateRoleRequestDto request) throws Exception {
		RoleResponseDto response = roleService.update(request);
		if (response == null)
			throw new MyException(ResponseCode.ERROR);
		return new BaseResponse<RoleResponseDto>(false, response, ResponseCode.OK);
	}

	/* get by id */
	@RequestMapping(path = PathMapping.ID_PARAM, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<RoleResponseDto> getRoleById(@PathVariable(PathMapping.ID) int id) throws Exception {
		RoleResponseDto response = roleService.getById(id);
		if (response == null) {
			return new BaseResponse<>(false, null, ResponseCode.NO_ROLE_PRESENT);
		}
		return new BaseResponse<RoleResponseDto>(false, response, ResponseCode.OK);
	}
	/*delete by id */
	@RequestMapping(path = PathMapping.ID_PARAM, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<RoleResponseDto> deleteById(@PathVariable(PathMapping.ID) int id) throws Exception {

		if (!roleService.delete(id)) {
			return new BaseResponse<>(false, null, ResponseCode.NO_ROLE_PRESENT);
		}
		return new BaseResponse<RoleResponseDto>(false, null, ResponseCode.OK);

	}

}
