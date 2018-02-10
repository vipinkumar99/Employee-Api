package com.emp.validator;

import com.emp.enums.ResponseCode;
import com.emp.exception.MyException;
import com.emp.request.dto.AddCompanyRequestDto;

public class CompanyValidator {

	public static void companyResponseDtoValidator(AddCompanyRequestDto validateRequest) throws MyException
	{
		if(validateRequest == null)
		{
			throw new MyException(ResponseCode.INVALID_ARGUMENT);
		}
		
	   if(validateRequest.getComName() == null)
	   {
		   throw new MyException(ResponseCode.NAME_EMPTY);
	   }
	   
	   if(validateRequest.getComPrice() <=1000)
	   {
		   throw new MyException(ResponseCode.MINIMUM_PRICE);
	   }
	   
	}
	
}
