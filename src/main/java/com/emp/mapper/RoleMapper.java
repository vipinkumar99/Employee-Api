package com.emp.mapper;

import java.util.ArrayList;
import java.util.List;

import com.emp.model.Role;
import com.emp.request.dto.AddRoleRequestDto;
import com.emp.request.dto.UpdateRoleRequestDto;
import com.emp.response.dto.RoleResponseDto;
import com.emp.utils.DateUtils;

public class RoleMapper {

	public static RoleResponseDto convertEntityToResponse(Role request) {
		if (request == null) {
			return null;
		}
		RoleResponseDto response = new RoleResponseDto();
		response.setId(request.getId());
		response.setName(request.getName());
		response.setCreated(DateUtils.dateConversion(request.getCreated(), DateUtils.FIRST_DATE_FORMAT));
		response.setUpdated(DateUtils.dateConversion(request.getUpdated(), DateUtils.FIRST_DATE_FORMAT));
		return response;

	}

	public static List<RoleResponseDto> convertEntityListToResponseList(List<Role> requestList) {
		if (requestList == null) {
			return null;
		}
		List<RoleResponseDto> responseList = new ArrayList<RoleResponseDto>(requestList.size());
		for (Role role : requestList)
			responseList.add(convertEntityToResponse(role));
		return responseList;
	}

	public static Role convertAddRequestToEntity(AddRoleRequestDto request) {
		if (request == null) {
			return null;
		}
		Role response = new Role();
		response.setName(request.getName());
		return response;
	}

	public static Role convertUpdateRoleToEntity(UpdateRoleRequestDto request) {
		if (request == null) {
			return null;
		}
		Role response = new Role();
		response.setId(request.getId());
		response.setName(request.getName());
		return response;
	}

}
