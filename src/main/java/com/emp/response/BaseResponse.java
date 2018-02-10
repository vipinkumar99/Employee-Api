package com.emp.response;

import com.emp.enums.ResponseCode;
import com.emp.exception.MyException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL)
public class BaseResponse<T> {

	public boolean error;
	public String message;
	public T data;
	public String statusCode;

	public BaseResponse(boolean error, String message, T data, String statusCode) {
		this.error = error;
		this.message = message;
		this.data = data;
		this.statusCode = statusCode;
	}

	public BaseResponse(boolean error,T data, ResponseCode statusCode) {
		this.error = error;
		this.message =statusCode.getMessage();
		this.data = data;
		this.statusCode = statusCode.getCode();
	}
	
	public BaseResponse(MyException Ex) {
		this.error =true;
		this.message =Ex.getMessage();
		this.data =null;
		this.statusCode =Ex.getCode();
	}
	
	
}
