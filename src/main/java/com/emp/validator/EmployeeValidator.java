package com.emp.validator;

import com.emp.enums.ResponseCode;
import com.emp.exception.MyException;
import com.emp.request.dto.AddEmployeeRequestDto;

public class EmployeeValidator {

	public static void addEmployeeRequestDtoValidator(AddEmployeeRequestDto employeeValidate) throws MyException {
		if (employeeValidate == null) {
			throw new MyException(ResponseCode.INVALID_ARGUMENT);
		}

		if (employeeValidate.getEmAge() <= 17) {
			throw new MyException(ResponseCode.AGE_LESS);
		}
		if (employeeValidate.getEmName() == null) {
			throw new MyException(ResponseCode.NAME_EMPTY);
		}
	}
	
	
	
}
