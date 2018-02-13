package com.emp.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dao.IRoleDao;
import com.emp.enums.ResponseCode;
import com.emp.exception.MyException;
import com.emp.mapper.RoleMapper;
import com.emp.model.Role;
import com.emp.request.dto.AddRoleRequestDto;
import com.emp.request.dto.UpdateRoleRequestDto;
import com.emp.response.dto.RoleResponseDto;
import com.emp.service.IRoleService;

@Service
public class RoleService implements IRoleService {

	@Autowired
	private IRoleDao roleDao;

	@Override
	public List<RoleResponseDto> getAll() {
		return RoleMapper.convertEntityListToResponseList(roleDao.all());
	}

	@Override
	public RoleResponseDto save(AddRoleRequestDto request) {
		Role response = RoleMapper.convertAddRequestToEntity(request);
		if (response == null) {
			return null;
		}
		roleDao.save(response);
		return RoleMapper.convertEntityToResponse(response);
	}

	@Override
	public RoleResponseDto update(UpdateRoleRequestDto request) throws MyException {
		Role response = RoleMapper.convertUpdateRoleToEntity(request);
		if (response == null) {
			return null;
		}
		Role entity = roleDao.getById(response.getId());
		if (entity == null) {
			throw new MyException(ResponseCode.INVALID_ARGUMENT);
		}
		response.setCreated(entity.getCreated());
		roleDao.update(response);
		return RoleMapper.convertEntityToResponse(response);
	}

	@Override
	public RoleResponseDto getById(int id) {
		return RoleMapper.convertEntityToResponse(roleDao.getById(id));
	}

	@Override
	public boolean delete(int id) {
		roleDao.delete(id);
		return true;
	}
}
