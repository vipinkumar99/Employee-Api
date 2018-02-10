package com.emp.mapper;

import java.util.ArrayList;
import java.util.List;

import com.emp.model.Item;
import com.emp.request.dto.AddItemRequestDto;
import com.emp.request.dto.UpdateItemRequestDto;
import com.emp.response.dto.ItemResponseDto;
import com.emp.utils.JsonMapperUtils;

public class ItemMapper {

	public static List<ItemResponseDto> convertResponseListToEntityList(List<Item>entityList)
	{
		if(entityList == null)
			return null;
		List<ItemResponseDto> responseList = new ArrayList<ItemResponseDto>(entityList.size());
		for(Item item : entityList)
		{
			responseList.add(convertEntityToResponse(item));
		}
		return responseList;
	}

public static ItemResponseDto convertEntityToResponse (Item entity)
{
	if(entity == null)
	return null;

	ItemResponseDto response = new ItemResponseDto();
	response.setId(entity.getId());
	response.setName(entity.getName());
	response.setImage(entity.getImage());
	response.setPrice(entity.getPrice());
	response.setQuntity(entity.getQuntity());
	response.setCategoryId(entity.getCategoryId());
	response.setMetaInfo(JsonMapperUtils.convertJsonToObject(entity.getMetaInfo(), Object.class));
	return response;
}

public static Item convertAddRequestToEntity(AddItemRequestDto request)
{
	if(request == null)
		return null;
	
	Item item = new Item();
	 item.setName(request.getName());
	 item.setImage(request.getImage());
	 item.setPrice(request.getPrice());
	 item.setQuntity(request.getQuntity());
	 item.setCategoryId(request.getCategoryId());
	 item.setMetaInfo(JsonMapperUtils.convertObjectToJson(request.getMetaInfo()));
	return item;
}

public static Item convertUpdateRequestToEntity(UpdateItemRequestDto request)
{
	if(request == null)
		return null;
	
	Item item = new Item();
	item.setId(request.getId());
	 item.setName(request.getName());
	 item.setImage(request.getImage());
	 item.setPrice(request.getPrice());
	 item.setQuntity(request.getQuntity());
	 item.setCategoryId(request.getCategoryId());
	 item.setMetaInfo(JsonMapperUtils.convertObjectToJson(request.getMetaInfo()));
	return item;
}


}
