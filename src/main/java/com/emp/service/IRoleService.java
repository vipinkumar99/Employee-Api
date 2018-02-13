package com.emp.service;

import java.util.List;

import com.emp.exception.MyException;
import com.emp.request.dto.AddRoleRequestDto;
import com.emp.request.dto.UpdateRoleRequestDto;
import com.emp.response.dto.RoleResponseDto;

public interface IRoleService {
	public List<RoleResponseDto> getAll();

	public RoleResponseDto save(AddRoleRequestDto request);

	public RoleResponseDto update(UpdateRoleRequestDto request) throws MyException;

	public RoleResponseDto getById(int id);

	public boolean delete(int id);

}
