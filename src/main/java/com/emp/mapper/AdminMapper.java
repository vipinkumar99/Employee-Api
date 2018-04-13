package com.emp.mapper;

import java.util.ArrayList;
import java.util.List;

import com.emp.model.Admin;
import com.emp.request.dto.AddAdminRequestDto;
import com.emp.request.dto.UpdateAdminRequestDto;
import com.emp.response.dto.AdminResponseDto;
import com.emp.utils.DateUtils;
import com.emp.utils.JsonMapperUtils;

public class AdminMapper {

	public static List<AdminResponseDto> convertEntityListToResponseList(List<Admin> requestList) {
		if (requestList == null) {
			return null;
		}
		List<AdminResponseDto> responseList = new ArrayList<AdminResponseDto>(requestList.size());
		for (Admin admin : requestList)
			responseList.add(convertEntityToResponse(admin));
		return responseList;
	}

	public static AdminResponseDto convertEntityToResponse(Admin request) {
		if (request == null) {
			return null;
		}
		AdminResponseDto response = new AdminResponseDto();
		response.setId(request.getId());
		response.setName(request.getName());
		response.setEmail(request.getEmail());
		response.setMobileNumber(request.getMobileNumber());
		response.setMetaInfo(JsonMapperUtils.convertJsonToObject(request.getMetaInfo(), Object.class));
		response.setUserName(request.getUserName());
		response.setCreated(DateUtils.dateConversion(request.getCreated(), DateUtils.FIRST_DATE_FORMAT));
		response.setUpdated(DateUtils.dateConversion(request.getUpdated(), DateUtils.FIRST_DATE_FORMAT));
		return response;
	}

	public static Admin convertAddRequestToEntity(AddAdminRequestDto request) {
		if (request == null) {
			return null;
		}
		Admin response = new Admin();
		response.setName(request.getName());
		response.setEmail(request.getEmail());
		response.setUserName(request.getUserName());
		response.setPassword(request.getPassword());
		response.setMobileNumber(request.getMobileNumber());
		response.setMetaInfo(JsonMapperUtils.convertObjectToJson(request.getMetaInfo()));
		return response;
	}

	public static Admin convertUpdateRequestToEntity(UpdateAdminRequestDto request) {
		if (request == null) {
			return null;
		}
		Admin response = new Admin();
		response.setId(request.getId());
		response.setName(request.getName());
		// response.setEmail(request.getEmail());
		// response.setUserName(request.getUserName());
		response.setMobileNumber(request.getMobileNumber());
		response.setMetaInfo(JsonMapperUtils.convertObjectToJson(request.getMetaInfo()));
		return response;
	}

}
