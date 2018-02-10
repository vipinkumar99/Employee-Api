package com.emp.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dao.ICompanyDao;
import com.emp.mapper.CompanyMapper;
import com.emp.model.Company;
import com.emp.request.dto.AddCompanyRequestDto;
import com.emp.request.dto.UpdateCompanyRequestDto;
import com.emp.response.dto.CompanyResponseDto;
import com.emp.service.ICompanyService;

@Service
public class CompanyService implements ICompanyService {

	@Autowired
	private ICompanyDao companyDao;

	@Override
	public List<CompanyResponseDto> getCompanyList() {

		return CompanyMapper.convertEntityListToResponseList(companyDao.all());
	}

	@Override
	public CompanyResponseDto saveCompany(AddCompanyRequestDto request) {
		Company company = CompanyMapper.convertAddRequestToEntity(request);
		if (company != null) {
			companyDao.save(company);
			return CompanyMapper.convertEntityToResponse(company);
		}
		return null;
	}

	@Override
	public CompanyResponseDto updateCompany(UpdateCompanyRequestDto request) {
		Company company = CompanyMapper.convertUpdateRequestToEntity(request);
		if(company == null)
		{
			return null;
		}
		companyDao.update(company);
		return CompanyMapper.convertEntityToResponse(company);
	}

	@Override 
	public boolean deleteCompany(int id) {
		companyDao.delete(id);
		return true;
	}

	@Override
	public CompanyResponseDto getById(int id) {
		return CompanyMapper.convertEntityToResponse(companyDao.getById(id));
	}

}
