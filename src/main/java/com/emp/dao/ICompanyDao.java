package com.emp.dao;

import java.util.List;

import com.emp.model.Company;

public interface ICompanyDao extends IAbstractDao<Company> {
	public List<Company> getAll(int start, int limit, String order);

	public List<Company> getByName(String name, int start, int limit, String order);

}
