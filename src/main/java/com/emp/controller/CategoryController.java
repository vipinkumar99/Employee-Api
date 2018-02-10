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
import org.springframework.web.bind.annotation.ResponseBody;

import com.emp.constants.PathMapping;
import com.emp.enums.ResponseCode;
import com.emp.exception.MyException;
import com.emp.request.dto.AddCategoryRequestDto;
import com.emp.request.dto.UpdateCategoryRequestDto;
import com.emp.response.BaseResponse;
import com.emp.response.dto.CategoryResponseDto;
import com.emp.service.ICategoryService;
import com.emp.validator.CategoryValidator;

@Controller
@RequestMapping(value = PathMapping.CategoryMapping.Base)
public class CategoryController {
	@Autowired
	ICategoryService categoryService;

  /* get all list */
	@RequestMapping(path = PathMapping.All, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<List<CategoryResponseDto>> getCategoryList() throws Exception {
		List<CategoryResponseDto> response = categoryService.getList();
		if (CollectionUtils.isEmpty(response)) {
			return new BaseResponse<>(false, null, ResponseCode.NO_CATEGORY_PRESENT);
		}
		return new BaseResponse<List<CategoryResponseDto>>(false, response, ResponseCode.OK);
	}

	/* save */
	@RequestMapping(path = PathMapping.SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<CategoryResponseDto> saveCategory(@RequestBody AddCategoryRequestDto request) throws Exception {
		CategoryValidator.categoryRequestValidator(request);
		CategoryResponseDto response = categoryService.save(request);
		if (response == null) {
			throw new MyException(ResponseCode.ERROR);
		}
		return new BaseResponse<CategoryResponseDto>(false, response, ResponseCode.OK);
	}

	/*update */
	@RequestMapping(path = PathMapping.UDATE, method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<CategoryResponseDto> updateStudent(@RequestBody UpdateCategoryRequestDto request)
			throws Exception {
		CategoryResponseDto response = categoryService.update(request);
		if (response == null)
			throw new MyException(ResponseCode.ERROR);
		return new BaseResponse<CategoryResponseDto>(false, response, ResponseCode.OK);
	}

	/* get by id */
	@RequestMapping(path = PathMapping.ID_PARAM, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<CategoryResponseDto> getCategoryById(@PathVariable(PathMapping.ID) int id) throws Exception {
		CategoryResponseDto response = categoryService.getById(id);
		if (response == null) {
			return new BaseResponse<>(false, null, ResponseCode.NO_CATEGORY_PRESENT);
		}

		return new BaseResponse<CategoryResponseDto>(false, response, ResponseCode.OK);
	}

	/*delete by id */
	@RequestMapping(path = PathMapping.ID_PARAM, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<CategoryResponseDto> deleteById(@PathVariable(PathMapping.ID) int id) throws Exception {

		if (!categoryService.delete(id)) {
			return new BaseResponse<>(false, null, ResponseCode.NO_CATEGORY_PRESENT);
		}
		return new BaseResponse<CategoryResponseDto>(false, null, ResponseCode.OK);

	}

	
}
