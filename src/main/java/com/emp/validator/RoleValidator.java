package com.emp.validator;

import org.springframework.util.StringUtils;

import com.emp.enums.ResponseCode;
import com.emp.exception.MyException;
import com.emp.request.dto.AddRoleRequestDto;

public class RoleValidator {

	public static void roleRequestValidator(AddRoleRequestDto roleToValidate) throws MyException {
		if (roleToValidate == null) {
			throw new MyException(ResponseCode.INVALID_ARGUMENT);

		}
		if (StringUtils.isEmpty(roleToValidate)) {
			throw new MyException(ResponseCode.NAME_EMPTY);
		}
	}

}
