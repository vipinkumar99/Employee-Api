package com.emp.request.dto;

import com.emp.pojo.AdminPojo;

public class AddAdminRequestDto extends AdminPojo {
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
