package com.emp.mapper;

import java.util.ArrayList;
import java.util.List;

import com.emp.model.Company;
import com.emp.request.dto.AddCompanyRequestDto;
import com.emp.request.dto.UpdateCompanyRequestDto;
import com.emp.response.dto.CompanyResponseDto;

public class CompanyMapper {

	public static List<CompanyResponseDto> convertEntityListToResponseList(List<Company> companyList) {
		if (companyList == null)
			return null;
		List<CompanyResponseDto> responseList = new ArrayList<CompanyResponseDto>(companyList.size());
		for (Company company : companyList)
			responseList.add(convertEntityToResponse(company));
		return responseList;
	}

	public static CompanyResponseDto convertEntityToResponse(Company company) {
		if (company == null)
			return null;

		CompanyResponseDto response = new CompanyResponseDto();
		response.setComId(company.getCompanyId());
		response.setComName(company.getCompanyName());
		response.setComPrice(company.getCompanyPrice());
		return response;

	}

	public static Company convertAddRequestToEntity(AddCompanyRequestDto request) {
		if (request == null)
			return null;
		Company response = new Company();
		response.setCompanyName(request.getComName());
		response.setCompanyPrice(request.getComPrice());
		return response;
	}

	public static Company convertUpdateRequestToEntity(UpdateCompanyRequestDto request) {
		if (request == null)
			return null;
		Company response = new Company();
		response.setCompanyName(request.getComName());
		response.setCompanyPrice(request.getComPrice());
		return response;
	}

	
	
	
}
