package com.emp.validator;

import org.springframework.util.StringUtils;

import com.emp.enums.ResponseCode;
import com.emp.exception.MyException;
import com.emp.request.dto.AddAdminRequestDto;

public class AdminValidator {

	public static void adminRequestValidator(AddAdminRequestDto requestToValidate) throws MyException {
		if (requestToValidate == null) {
		}
		if (StringUtils.isEmpty(requestToValidate.getName())) {
           throw new MyException(ResponseCode.NAME_EMPTY);
		}
		if (StringUtils.isEmpty(requestToValidate.getEmail())) {
          throw new MyException(ResponseCode.EMAIL_EMPTY);
		}
		if (StringUtils.isEmpty(requestToValidate.getPassword())) {
             throw new MyException(ResponseCode.PASSWORD_EMPTY);
		}
		if (StringUtils.isEmpty(requestToValidate.getUserName())) {
           throw new MyException(ResponseCode.USERNAME_EMPTY);
		}
		if (StringUtils.isEmpty(requestToValidate.getMetaInfo())) {
            throw new MyException(ResponseCode.NO_METAINFO_PRESENT);
		}
		if (requestToValidate.getMobileNumber() == 0) {
        throw new MyException(ResponseCode.INVALID_MOBILE_NUMBER);
		}
	}

}
