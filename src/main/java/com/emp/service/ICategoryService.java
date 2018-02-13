package com.emp.service;

import java.util.List;

import com.emp.request.dto.AddCategoryRequestDto;
import com.emp.request.dto.UpdateCategoryRequestDto;
import com.emp.response.dto.CategoryResponseDto;

public interface ICategoryService {

	public List<CategoryResponseDto> getList();
	public CategoryResponseDto save(AddCategoryRequestDto request);
	public CategoryResponseDto  update(UpdateCategoryRequestDto request);
	public CategoryResponseDto  getById(int id);
	public boolean delete(int id);
//	public List<CategoryResponseDto> saveMultipleItem(List<AddItemRequestDto> listToSave);
	
}
