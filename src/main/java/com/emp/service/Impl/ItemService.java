package com.emp.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.emp.dao.ICategoryDao;
import com.emp.dao.IItemDao;
import com.emp.enums.ResponseCode;
import com.emp.exception.MyException;
import com.emp.mapper.ItemMapper;
import com.emp.model.Item;
import com.emp.request.dto.AddItemRequestDto;
import com.emp.request.dto.UpdateItemRequestDto;
import com.emp.response.dto.CategoryResponseDto;
import com.emp.response.dto.ItemResponseDto;
import com.emp.service.ICategoryService;
import com.emp.service.IItemService;
import com.emp.utils.NumberUtils;

@Service
public class ItemService implements IItemService {

	@Autowired
	private IItemDao itemDao;

	@Autowired
	private ICategoryDao categoryDao;

	@Autowired
	private ICategoryService categoryService;

	@Override
	public List<ItemResponseDto> getList() {
		return getResponselist(itemDao.all());

	}

	@Override
	public ItemResponseDto save(AddItemRequestDto request) throws MyException {
		Item item = ItemMapper.convertAddRequestToEntity(request);
		if (item == null) {
			return null;
		}
		if (categoryDao.getById(item.getCategoryId()) == null) {
			throw new MyException(ResponseCode.INVALID_CATEGORY_ID);
		}
		double total = NumberUtils.totalPrice(item.getQuntity(), item.getPrice());
		item.setTotalPrice(total);
		itemDao.save(item);
		return getResponse(item);
	}

	@Override
	public ItemResponseDto update(UpdateItemRequestDto request) throws MyException {
		Item item = ItemMapper.convertUpdateRequestToEntity(request);
		if (item == null) {
			return null;
		}

		if (categoryDao.getById(item.getCategoryId()) == null) {
			throw new MyException(ResponseCode.INVALID_CATEGORY_ID);
		}

		itemDao.update(item);
		return getResponse(item);
	}

	@Override
	public ItemResponseDto getById(int id) {
		return getResponse(itemDao.getById(id));
	}

	@Override
	public boolean delete(int id) {
		itemDao.delete(id);
		return true;
	}

	@Override
	public List<ItemResponseDto> getByCategoryId(int categoryId) {
		return getResponselist(itemDao.getItemByCategoryId(categoryId));

	}

	public ItemResponseDto getResponse(Item item) {
		ItemResponseDto response = ItemMapper.convertEntityToResponse(item);
		if (response == null) {
			return null;
		}
		CategoryResponseDto category = categoryService.getById(item.getCategoryId());
		response.setCategory(category);
		return response;
	}

	public List<ItemResponseDto> getResponselist(List<Item> itemList) {
		if (CollectionUtils.isEmpty(itemList)) {
			return null;
		}
		List<ItemResponseDto> responseList = new ArrayList<>(itemList.size());
		for (Item item : itemList) {
			ItemResponseDto response = getResponse(item);
			if (response != null) {
				responseList.add(response);
			}
		}
		return responseList;
	}

	@Override
	public void saveList(List<AddItemRequestDto> listToSave, int categoryId) {
		List<Item> requstList = ItemMapper.convertAddRequestListToEntityList(listToSave, categoryId);
		if (CollectionUtils.isEmpty(requstList)) {
			return;
		}
		itemDao.saveListOfItem(requstList);
	}

}
