package com.emp.dao;

import java.util.List;

public interface IAbstractDao <T> {
	public void  save(T itemToSave);
	public void update(T itemToUpdate);
	public void  delete(int id);
	public List<T> all();
	public  T getById(int id);
	
}
