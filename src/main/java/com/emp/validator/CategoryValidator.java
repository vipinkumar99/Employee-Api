package com.emp.validator;

import com.emp.enums.ResponseCode;
import com.emp.exception.MyException;
import com.emp.request.dto.AddCategoryRequestDto;

public class CategoryValidator {
	
public static void categoryRequestValidator (AddCategoryRequestDto validateCategory) throws MyException
{
	if(validateCategory == null)
	{
		throw new MyException(ResponseCode.INVALID_ARGUMENT);
	}
	if(validateCategory.getName() == null)
	{
	 throw new MyException(ResponseCode.NO_CATEGORY_PRESENT);	
	}
	
	if(validateCategory.getImage() == null)
	{
		throw new MyException(ResponseCode.NO_IMAGE_PRESENT);
	}
	
	if(validateCategory.getAdditionalUrl() == null)
	{
		throw new MyException(ResponseCode.NO_URL_PRESENT);
		
	}
	
	if(validateCategory.getMetaInfo() == null)
	{
		throw new MyException(ResponseCode.NO_METAINFO_PRESENT);
	}
	
	if(validateCategory.getParentId() == 0)
	{
		throw new MyException(ResponseCode.ERROR);
	}
}



}
