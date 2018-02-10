package com.emp.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dao.ICategoryDao;
import com.emp.mapper.CategoryMapper;
import com.emp.model.Category;
import com.emp.request.dto.AddCategoryRequestDto;
import com.emp.request.dto.UpdateCategoryRequestDto;
import com.emp.response.dto.CategoryResponseDto;
import com.emp.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	ICategoryDao categoryDao;

	@Override
	public List<CategoryResponseDto> getList() {
		return CategoryMapper.convertEntityListToResponseList(categoryDao.all());
	}

	@Override
	public CategoryResponseDto save(AddCategoryRequestDto request) {
	Category category = CategoryMapper.convertAddRequestToEntity(request);
	if(category != null)
	{
		categoryDao.save(category);
		return CategoryMapper.convertEntityToResponse(category);
	}
	return null;
		
	}

	@Override
	public CategoryResponseDto update(UpdateCategoryRequestDto request) {
		Category category = CategoryMapper.convertUpdateRequestToEntity(request);
		if (category == null) {
			return null;
		}
		categoryDao.update(category);
		return CategoryMapper.convertEntityToResponse(category);
	}

	@Override
	public CategoryResponseDto getById(int id) {
		return CategoryMapper.convertEntityToResponse(categoryDao.getById(id));
	}

	@Override
	public boolean delete(int id) {
		categoryDao.delete(id);
		return true;
	}

}
