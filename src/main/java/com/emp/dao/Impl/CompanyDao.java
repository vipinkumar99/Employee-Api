package com.emp.dao.Impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.emp.dao.ICompanyDao;
import com.emp.model.Company;

@Repository
@Transactional
public class CompanyDao extends AbstractDao<Company> implements ICompanyDao {

	public CompanyDao() {
		super(Company.class);
		
	}

}
