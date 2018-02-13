package com.emp.dao.Impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.emp.dao.IRoleDao;
import com.emp.model.Role;

@Repository
@Transactional
public class RoleDao extends AbstractDao<Role> implements IRoleDao {

	public RoleDao() {
		super(Role.class);
	}
}
