package com.emp.exception;

import com.emp.enums.ResponseCode;

@SuppressWarnings("serial")
public class MyException extends Exception {
	
	private String code;

	public String getCode() {
		return code;
	}


	public MyException(String message,String code) {
		super(message);
		this.code = code;
	}
	
	public MyException(ResponseCode responseCode) {
		super(responseCode.getMessage());
		this.code = responseCode.getCode();
	}

}
