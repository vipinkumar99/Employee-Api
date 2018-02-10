package com.emp.response.dto;

import com.emp.pojo.EmployeePojo;

public class EmployeeResponseDto extends EmployeePojo {

	private int emId;
	private String createDate;
	private String updateDate;

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public int getEmId() {
		return emId;
	}

	public void setEmId(int emId) {
		this.emId = emId;
	}

}
