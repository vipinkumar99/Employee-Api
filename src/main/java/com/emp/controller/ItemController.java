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
import com.emp.request.dto.AddItemRequestDto;
import com.emp.request.dto.UpdateItemRequestDto;
import com.emp.response.BaseResponse;
import com.emp.response.dto.EmployeeResponseDto;
import com.emp.response.dto.ItemResponseDto;
import com.emp.service.IItemService;
import com.emp.validator.ItemValidator;

@Controller
@RequestMapping(value=PathMapping.ItemMapping.Base)
public class ItemController {

	@Autowired
	IItemService itemService;
	
	 /* get all list */
		@RequestMapping(path = PathMapping.All, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public BaseResponse<List<ItemResponseDto>> getItemList() throws Exception {
			List<ItemResponseDto> response = itemService.getList();
			if (CollectionUtils.isEmpty(response)) {
				return new BaseResponse<>(false, null, ResponseCode.NO_ITEM_PRESENT);
			}
			return new BaseResponse<List<ItemResponseDto>>(false, response, ResponseCode.OK);
		}

		/* save */
		@RequestMapping(path = PathMapping.SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public BaseResponse<ItemResponseDto> saveItem(@RequestBody AddItemRequestDto request) throws Exception {
			ItemValidator.itemRequestValidator(request);
			ItemResponseDto response = itemService.save(request);
			if (response == null) {
				throw new MyException(ResponseCode.ERROR);
			}
			return new BaseResponse<ItemResponseDto>(false, response, ResponseCode.OK);
		}

		/*update */
		@RequestMapping(path = PathMapping.UDATE, method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public BaseResponse<ItemResponseDto> updateItem(@RequestBody UpdateItemRequestDto request)
				throws Exception {
			ItemResponseDto response = itemService.update(request);
			if (response == null)
				throw new MyException(ResponseCode.ERROR);
			return new BaseResponse<ItemResponseDto>(false, response, ResponseCode.OK);
		}

		/* get by id */
		@RequestMapping(path = PathMapping.ID_PARAM, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public BaseResponse<ItemResponseDto> getItemById(@PathVariable(PathMapping.ID) int id) throws Exception {
			ItemResponseDto response = itemService.getById(id);
			if (response == null) {
				return new BaseResponse<>(false, null, ResponseCode.NO_ITEM_PRESENT);
			}

			return new BaseResponse<ItemResponseDto>(false, response, ResponseCode.OK);
		}


		/* get by categoryid */
		@RequestMapping(path = PathMapping.CATEGORY_ID ,method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public BaseResponse<List<ItemResponseDto> >getItemByCategoryId(@PathVariable(PathMapping.CID) int id) throws Exception {
			List<ItemResponseDto> response = itemService.getByCategoryId(id);
			if (response == null) {
				return new BaseResponse<>(false, null, ResponseCode.NO_ITEM_PRESENT);
			}

			return new BaseResponse <List<ItemResponseDto>>(false, response, ResponseCode.OK);
		}

		
				
		
		/*delete by id */
		@RequestMapping(path = PathMapping.ID_PARAM, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public BaseResponse<ItemResponseDto> deleteById(@PathVariable(PathMapping.ID) int id) throws Exception {

			if (!itemService.delete(id)) {
				return new BaseResponse<>(false, null, ResponseCode.NO_ITEM_PRESENT);
			}
			return new BaseResponse<ItemResponseDto>(false, null, ResponseCode.OK);

		}

	
}
