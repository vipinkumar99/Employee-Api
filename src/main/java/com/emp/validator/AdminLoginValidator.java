package com.emp.validator;

import org.springframework.util.StringUtils;

import com.emp.enums.ResponseCode;
import com.emp.exception.MyException;
import com.emp.request.dto.AdminLoginRequestDto;

public class AdminLoginValidator {

	public static void adminLoginValidator(AdminLoginRequestDto requestToValidate) throws MyException {
		if (requestToValidate == null) {
			throw new MyException(ResponseCode.INVALID_ARGUMENT);
		}
		if (StringUtils.isEmpty(requestToValidate.getUserName())) {
			throw new MyException(ResponseCode.NO_USER_PRESENT);
		}
		if (StringUtils.isEmpty(requestToValidate.getPassword())) {
			throw new MyException(ResponseCode.PASSWORD_EMPTY);
		}
	}

}
