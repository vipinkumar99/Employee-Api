package com.emp.enums;

public enum ResponseCode {

	OK("Successfull", "0"),
	ERROR("Internal sever error", "100"), 
	COMMON_CODE("",""), 
	INVALID_ARGUMENT("Argument are invalid", "10"), 
	NO_EMPLOYEE_PRESENT("Employe not found","NOT_FOUND"),
//	NO_EMPLYEE_PRESENT("Employee id is not found", "NOT_FOUND"), 
	NAME_EMPTY("Name is empty","NAME_EMPTY"), 
	AGE_LESS("Age is less than 18 year","AGE_SMALL"),
	MINIMUM_PRICE("Price is less than 2000","MINI_PRICE"), 
	NO_COMPANY_PRESENT("Company not found","NOT_FOUND"), 
	NO_CATEGORY_PRESENT("Category not found","NOT_FOUND"), 
	NO_IMAGE_PRESENT("Image not found","NOT_FOUND"),
	NO_URL_PRESENT("Url not found","NOT_FOUND"),
	NO_METAINFO_PRESENT("Meta info not found","NOT_FOUND"), 
	NO_QUNTITY_PRESENT("Quntity is zero","ZERO_QUNTITY"),
	NO_ITEM_PRESENT("Item not found","NOT_FOUND"), 
	INVALID_CATEGORY_ID("Category Id is not valid", "NOT_VALID");
	;

	private String message;
	private String code;

	public String getMessage() {
		return message;
	}

	public String getCode() {
		return code;
	}

	private ResponseCode(String message, String code) {
		this.message = message;
		this.code = code;
	}

	public static ResponseCode formatResponseCode(final ResponseCode responseCode, String message) {
		ResponseCode commonCode = COMMON_CODE;
		commonCode.message = String.format(responseCode.message, message);
		return commonCode;
	}

}
