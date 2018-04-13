package com.emp.response.dto;

import com.emp.pojo.ItemPojo;

public class ItemResponseDto extends ItemPojo {

	private double totalPrice;

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	private int id;
	private CategoryResponseDto category;

	public CategoryResponseDto getCategory() {
		return category;
	}

	public void setCategory(CategoryResponseDto category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
