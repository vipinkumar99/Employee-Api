package com.emp.request.dto;

import java.util.List;

import com.emp.pojo.ItemPojo;

public class AddItemRequestDto extends ItemPojo {

	private double totalPrice;

	private List<AddCompanyRequestDto> company;

	public List<AddCompanyRequestDto> getCompany() {
		return company;
	}

	public void setCompany(List<AddCompanyRequestDto> company) {
		this.company = company;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
