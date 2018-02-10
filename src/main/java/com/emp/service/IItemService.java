package com.emp.service;

import java.util.List;

import com.emp.exception.MyException;
import com.emp.request.dto.AddItemRequestDto;
import com.emp.request.dto.UpdateItemRequestDto;
import com.emp.response.dto.ItemResponseDto;

public interface IItemService {
	public List<ItemResponseDto> getList();
	public ItemResponseDto save(AddItemRequestDto request) throws MyException;
	public ItemResponseDto  update(UpdateItemRequestDto request) throws MyException;
	public ItemResponseDto  getById(int id);
	public boolean delete(int id);
	public List<ItemResponseDto> getByCategoryId(int categoryId);
	
}
