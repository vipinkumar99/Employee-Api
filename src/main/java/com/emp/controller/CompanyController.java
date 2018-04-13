package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emp.constants.PathMapping;
import com.emp.enums.ResponseCode;
import com.emp.exception.MyException;
import com.emp.request.dto.AddCompanyRequestDto;
import com.emp.request.dto.UpdateCompanyRequestDto;
import com.emp.response.BaseResponse;
import com.emp.response.dto.CompanyResponseDto;
import com.emp.service.ICompanyService;
import com.emp.validator.CompanyValidator;

@Controller
@RequestMapping(value = PathMapping.CompanyMapping.Base)
public class CompanyController {

	@Autowired
	ICompanyService companyService;

	/* get all list */
	@RequestMapping(path = PathMapping.All, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<List<CompanyResponseDto>> getCompanyList() throws Exception {
		List<CompanyResponseDto> response = companyService.getCompanyList();
		if (CollectionUtils.isEmpty(response)) {
			return new BaseResponse<>(false, null, ResponseCode.NO_COMPANY_PRESENT);
		}
		return new BaseResponse<List<CompanyResponseDto>>(false, response, ResponseCode.OK);
	}

	/* get all by pagination by get method */
	@RequestMapping(path = PathMapping.PAGINATION, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<List<CompanyResponseDto>> getCompanyListByPaginationByGet(
			@RequestParam(name = PathMapping.PAGE_PARAM, required = true) int page,
			@RequestParam(name = PathMapping.PAGE_SIZE_PARAM, required = true) int size) throws Exception {
		List<CompanyResponseDto> response = companyService.getByPage(page, size);
		if (CollectionUtils.isEmpty(response)) {
			return new BaseResponse<>(false, null, ResponseCode.NO_COMPANY_PRESENT);
		}
		return new BaseResponse<List<CompanyResponseDto>>(false, response, ResponseCode.OK);
	}

	/* get all by pagination by post method */
	@RequestMapping(path = PathMapping.PAGINATION, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<List<CompanyResponseDto>> getCompanyListByPagination(
			@RequestParam(value = PathMapping.CompanyMapping.START, required = true) int start,
			@RequestParam(value = PathMapping.CompanyMapping.END, required = true) int end) throws Exception {
		List<CompanyResponseDto> response = companyService.getByPage(start, end);
		if (CollectionUtils.isEmpty(response)) {
			return new BaseResponse<>(false, null, ResponseCode.NO_COMPANY_PRESENT);
		}
		return new BaseResponse<List<CompanyResponseDto>>(false, response, ResponseCode.OK);
	}

	/* save */
	@RequestMapping(path = PathMapping.SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<CompanyResponseDto> saveCustomer(@RequestBody AddCompanyRequestDto request) throws Exception {
		CompanyValidator.companyResponseDtoValidator(request);
		CompanyResponseDto response = companyService.saveCompany(request);
		if (response == null) {
			throw new MyException(ResponseCode.ERROR);
		}
		return new BaseResponse<CompanyResponseDto>(false, response, ResponseCode.OK);
	}

	/* get by id */
	@RequestMapping(path = PathMapping.ID_PARAM, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<CompanyResponseDto> getCompanyById(@PathVariable(PathMapping.ID) int id) throws Exception {
		CompanyResponseDto response = companyService.getById(id);
		if (response == null) {
			return new BaseResponse<>(false, null, ResponseCode.NO_COMPANY_PRESENT);
		}

		return new BaseResponse<CompanyResponseDto>(false, response, ResponseCode.OK);
	}

	/* update */
	@RequestMapping(path = PathMapping.UDATE, method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<CompanyResponseDto> updateCompany(@RequestBody UpdateCompanyRequestDto request)
			throws Exception {
		CompanyValidator.companyResponseDtoValidator(request);
		CompanyResponseDto response = companyService.updateCompany(request);
		if (response == null)
			return new BaseResponse<>(false, null, ResponseCode.NO_COMPANY_PRESENT);
		return new BaseResponse<CompanyResponseDto>(false, response, ResponseCode.OK);
	}

	/* delete by id */
	@RequestMapping(path = PathMapping.ID_PARAM, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<CompanyResponseDto> deleteById(@PathVariable(PathMapping.ID) int id) throws Exception {

		if (!companyService.deleteCompany(id)) {
			return new BaseResponse<>(false, null, ResponseCode.NO_EMPLOYEE_PRESENT);
		}
		return new BaseResponse<CompanyResponseDto>(false, null, ResponseCode.OK);

	}
}
