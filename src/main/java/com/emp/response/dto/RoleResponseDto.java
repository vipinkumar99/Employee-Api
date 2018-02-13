package com.emp.response.dto;

import com.emp.pojo.RolePojo;

public class RoleResponseDto extends RolePojo {

	private int id;

	private String created;
	private String updated;

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
