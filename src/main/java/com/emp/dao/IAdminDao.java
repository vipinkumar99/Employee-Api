package com.emp.dao;

import com.emp.model.Admin;


public interface IAdminDao extends IAbstractDao<Admin> {
	public Admin getByUserName(String userName);
	public Admin getByMobileNumber(long mobileNumber);
	public Admin getByEmailId(String emailId);
	public Admin validatePassword(String password);

}
