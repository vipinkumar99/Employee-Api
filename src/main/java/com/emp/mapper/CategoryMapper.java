package com.emp.mapper;

import java.util.ArrayList;
import java.util.List;

import com.emp.model.Category;
import com.emp.request.dto.AddCategoryRequestDto;
import com.emp.request.dto.UpdateCategoryRequestDto;
import com.emp.response.dto.CategoryResponseDto;
import com.emp.utils.JsonMapperUtils;

public class CategoryMapper {
	public static List<CategoryResponseDto> convertEntityListToResponseList(List<Category> entityList) {
		if (entityList == null)
			return null;
		List<CategoryResponseDto> responseList = new ArrayList<CategoryResponseDto>(entityList.size());
		for (Category category : entityList)
			responseList.add(convertEntityToResponse(category));
		return responseList;
	}

	public static CategoryResponseDto convertEntityToResponse(Category entity) {
		if (entity == null)
			return null;

		CategoryResponseDto response = new CategoryResponseDto();
		response.setId(entity.getId());
		response.setName(entity.getName());
		response.setImage(entity.getImage());
		response.setAdditionalUrl(JsonMapperUtils.convertToList(entity.getAdditionalUrl(), String.class));
		response.setMetaInfo(JsonMapperUtils.convertJsonToObject(entity.getMetaInfo(), Object.class));
		response.setParentId(entity.getParentId());
		return response;
	}

	public static Category convertAddRequestToEntity(AddCategoryRequestDto request) {
		if (request == null)
			return null;

		Category response = new Category();
		response.setName(request.getName());
		response.setImage(request.getImage());
		response.setAdditionalUrl(JsonMapperUtils.convertObjectToJson(request.getAdditionalUrl()));
		response.setParentId(request.getParentId());
		response.setMetaInfo(JsonMapperUtils.convertObjectToJson(request.getMetaInfo()));
		return response;

	}

	public static Category convertUpdateRequestToEntity(UpdateCategoryRequestDto request) {
		if (request == null)
			return null;

		Category response = new Category();
		response.setId(request.getId());
		response.setName(request.getName());
		response.setImage(request.getImage());
		response.setAdditionalUrl(JsonMapperUtils.convertObjectToJson(request.getAdditionalUrl()));
		response.setParentId(request.getParentId());
		response.setMetaInfo(JsonMapperUtils.convertObjectToJson(request.getMetaInfo()));
		return response;

	}

}
