package com.emp.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dao.ICategoryDao;
import com.emp.dao.IItemDao;
import com.emp.mapper.CategoryMapper;
import com.emp.mapper.ItemMapper;
import com.emp.model.Category;
import com.emp.model.Item;
import com.emp.request.dto.AddCategoryRequestDto;
import com.emp.request.dto.AddItemRequestDto;
import com.emp.request.dto.UpdateCategoryRequestDto;
import com.emp.response.dto.CategoryResponseDto;
import com.emp.service.ICategoryService;
import com.emp.service.ICompanyService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	ICategoryDao categoryDao;

	@Autowired
	ItemService itemService;
	@Autowired
	ICompanyService companyService;
	@Autowired
	private IItemDao itemDao;

	@Override
	public List<CategoryResponseDto> getList() {
		return CategoryMapper.convertEntityListToResponseList(categoryDao.all());
	}

	@Override
	public CategoryResponseDto save(AddCategoryRequestDto request) {
		List<AddItemRequestDto> itemList = request.getItemList();
		Category category = CategoryMapper.convertAddRequestToEntity(request);
		if (category == null) {
			return null;
		}
		categoryDao.save(category);
		for (AddItemRequestDto item : itemList) {
			Item entity = ItemMapper.convertAddRequestToEntity(item);
			entity.setCategoryId(category.getId());
			itemDao.save(entity);
			companyService.saveList(item.getCompany());
		}
		return CategoryMapper.convertEntityToResponse(category);
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
