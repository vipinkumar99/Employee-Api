package com.emp.validator;

import org.springframework.web.multipart.MultipartFile;

import com.emp.enums.ResponseCode;
import com.emp.exception.MyException;

public class FileValidator {

	public static void addFileValidator(MultipartFile file) throws MyException {
		if (file == null || file.isEmpty()) {
			throw new MyException(ResponseCode.NO_FILE_PRESENT);
		}
		}
}
