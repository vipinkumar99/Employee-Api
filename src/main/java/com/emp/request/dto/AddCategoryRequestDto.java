package com.emp.request.dto;

import java.util.List;

import com.emp.pojo.CategoryPojo;

public class AddCategoryRequestDto extends CategoryPojo {

	private List<AddItemRequestDto> itemList;

	public List<AddItemRequestDto> getItemList() {
		return itemList;
	}

	public void setItemList(List<AddItemRequestDto> itemList) {
		this.itemList = itemList;
	}

}
