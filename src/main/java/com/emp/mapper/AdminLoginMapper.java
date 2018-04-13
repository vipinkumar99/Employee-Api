package com.emp.mapper;

import com.emp.model.Admin;
import com.emp.request.dto.AdminLoginRequestDto;

public class AdminLoginMapper {

	public static Admin convertAddLoginRequestToEntity(AdminLoginRequestDto request) {
		Admin response = new Admin();
		response.setUserName(request.getUserName());
		response.setPassword(request.getPassword());
		return response;
	}
}
