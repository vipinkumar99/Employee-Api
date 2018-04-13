package com.emp.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dao.IAdminDao;
import com.emp.enums.ResponseCode;
import com.emp.exception.MyException;
import com.emp.mapper.AdminLoginMapper;
import com.emp.mapper.AdminMapper;
import com.emp.model.Admin;
import com.emp.request.dto.AddAdminRequestDto;
import com.emp.request.dto.AdminLoginRequestDto;
import com.emp.request.dto.UpdateAdminRequestDto;
import com.emp.response.dto.AdminResponseDto;
import com.emp.service.IAdminService;

@Service
public class AdminService implements IAdminService {

	@Autowired
	private IAdminDao adminDao;

	@Override
	public List<AdminResponseDto> getAll() {
		return AdminMapper.convertEntityListToResponseList(adminDao.all());
	}

	@Override
	public AdminResponseDto save(AddAdminRequestDto request) throws MyException {
		Admin response = AdminMapper.convertAddRequestToEntity(request);
		if (response == null) {
			return null;
		}
		if (adminDao.getByMobileNumber(response.getMobileNumber()) != null) {
			throw new MyException(ResponseCode.MOBILE_NUMBER_PRESENT);

		}
		if (adminDao.getByEmailId(response.getEmail()) != null) {
			throw new MyException(ResponseCode.EMAIL_PRESENT);
		}
		if (adminDao.getByUserName(response.getUserName()) != null) {
			throw new MyException(ResponseCode.USERNAME_PRESENT);
		}

		adminDao.save(response);
		return AdminMapper.convertEntityToResponse(response);
	}

	@Override
	public AdminResponseDto update(UpdateAdminRequestDto request) throws MyException {
		Admin response = AdminMapper.convertUpdateRequestToEntity(request);
		if (response == null) {
			return null;
		}
		Admin entity = adminDao.getByMobileNumber(response.getMobileNumber());
		if (entity != null && entity.getId() != response.getId()) {
			throw new MyException(ResponseCode.MOBILE_NUMBER_PRESENT);
		}
		response.setPassword(entity.getPassword());
		response.setUserName(entity.getUserName());
		response.setEmail(entity.getEmail());
		response.setCreated(entity.getCreated());
		adminDao.update(response);
		return AdminMapper.convertEntityToResponse(response);
	}

	@Override
	public AdminResponseDto getById(int id) {
		return AdminMapper.convertEntityToResponse(adminDao.getById(id));
	}

	@Override
	public boolean delete(int id) {
		adminDao.delete(id);
		return true;
	}

	@Override
	public AdminResponseDto getByMobile(long mobileNumber) {
		return AdminMapper.convertEntityToResponse(adminDao.getByMobileNumber(mobileNumber));
	}

	@Override
	public boolean login(AdminLoginRequestDto loginRequest) {
		Admin entity = AdminLoginMapper.convertAddLoginRequestToEntity(loginRequest);
		if (entity == null) {
			return false;
		}
		Admin loginResponse = adminDao.getByUserName(entity.getUserName());
		if (loginResponse != null && entity.getPassword().equals(loginResponse.getPassword())) {
			return true;
		}
		return false;
	}

	@Override
	public boolean passwordChange(AdminLoginRequestDto request) throws MyException {
		Admin entity = AdminLoginMapper.convertAddLoginRequestToEntity(request);
		if (entity == null) {
			return false;
		}
		Admin response = adminDao.getByUserName(entity.getUserName());
		if (response == null) {
			throw new MyException(ResponseCode.NO_ADMIN_PRESENT);
		}
		if (request.getPassword().equals(response.getPassword()))
			response.setPassword(request.getNewPassword());
		adminDao.update(response);
		return true;
	}

}
