package com.emp.dao;

import java.util.List;

import com.emp.model.Item;

public interface IItemDao extends IAbstractDao<Item> {

	public List<Item>  getItemByCategoryId(int id);
	public void saveListOfItem(List<Item>itemList);
	
}
