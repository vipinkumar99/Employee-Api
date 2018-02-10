package com.emp.validator;

import com.emp.enums.ResponseCode;
import com.emp.exception.MyException;
import com.emp.request.dto.AddItemRequestDto;

public class ItemValidator {

	public static void itemRequestValidator(AddItemRequestDto validateItem) throws MyException {
		if (validateItem == null) {
			throw new MyException(ResponseCode.INVALID_ARGUMENT);
		}

		if (validateItem.getImage() == null) {
			throw new MyException(ResponseCode.NO_IMAGE_PRESENT);
		}

		if (validateItem.getName() == null) {
			throw new MyException(ResponseCode.NAME_EMPTY);
		}
		if (validateItem.getPrice() <= 100) {
			throw new MyException(ResponseCode.MINIMUM_PRICE);
		}
		if (validateItem.getMetaInfo() == null) {
			throw new MyException(ResponseCode.NO_METAINFO_PRESENT);
		}
		if (validateItem.getQuntity() == 0) {
			throw new MyException(ResponseCode.NO_QUNTITY_PRESENT);
		}

		if (validateItem.getCategoryId() == 0) {
			throw new MyException(ResponseCode.NO_CATEGORY_PRESENT);
		}
	}

}
