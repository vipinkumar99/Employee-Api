package com.emp.service;

import java.util.List;

import com.emp.request.dto.AddCompanyRequestDto;
import com.emp.request.dto.UpdateCompanyRequestDto;
import com.emp.response.dto.CompanyResponseDto;

public interface ICompanyService {

	public List<CompanyResponseDto> getCompanyList();
	public CompanyResponseDto  saveCompany(AddCompanyRequestDto company);
	public CompanyResponseDto  updateCompany(UpdateCompanyRequestDto company);
	public CompanyResponseDto getById(int id);
	public boolean deleteCompany(int id);
}
