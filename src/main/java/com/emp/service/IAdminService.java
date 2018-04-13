package com.emp.service;

import java.util.List;

import com.emp.exception.MyException;
import com.emp.request.dto.AddAdminRequestDto;
import com.emp.request.dto.AdminLoginRequestDto;
import com.emp.request.dto.UpdateAdminRequestDto;
import com.emp.response.dto.AdminResponseDto;

public interface IAdminService {

	public List<AdminResponseDto> getAll();

	public AdminResponseDto save(AddAdminRequestDto request) throws MyException;

	public AdminResponseDto update(UpdateAdminRequestDto request) throws MyException;

	public AdminResponseDto getById(int id);

	public boolean delete(int id);

	public AdminResponseDto getByMobile(long mobileNumber);

	boolean login(AdminLoginRequestDto loginRequest);

	boolean passwordChange(AdminLoginRequestDto request) throws MyException;

}
