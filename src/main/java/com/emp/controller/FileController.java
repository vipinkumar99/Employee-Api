package com.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.emp.constants.PathMapping;
import com.emp.enums.FileType;
import com.emp.enums.ResponseCode;
import com.emp.exception.MyException;
import com.emp.response.BaseResponse;
import com.emp.response.dto.FileResponseDto;
import com.emp.service.IFileService;
import com.emp.validator.FileValidator;

@Controller
@RequestMapping(path = PathMapping.File.BASE)
public class FileController {

	@Autowired
	IFileService fileService;

	@RequestMapping(path = PathMapping.SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<FileResponseDto> saveInLocalDisk(
			@RequestParam(value = PathMapping.File.FILE_PARAM_VAR, required = true) MultipartFile file)
					throws Exception {
		FileValidator.addFileValidator(file);
		FileResponseDto response = fileService.saveFileLocalDisk(file);
		if (response == null) {
			throw new MyException(ResponseCode.NO_URL_PRESENT);
		}
		return new BaseResponse<FileResponseDto>(false, response, ResponseCode.OK);
	}

	@RequestMapping(path = PathMapping.UPLOAD, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<String> saveInCloud(
			@RequestParam(value = PathMapping.File.FILE_PARAM_VAR, required = true) MultipartFile file,
			@RequestParam(value = PathMapping.File.FILE_TYPE_PARAM_VAR, required = true) FileType fileType)
					throws Exception {
		String response = fileService.saveFileCloud(file, fileType);
		if (response == null) {
			throw new MyException(ResponseCode.NO_URL_PRESENT);
		}
		return new BaseResponse<String>(false, response, ResponseCode.OK);
	}

	@RequestMapping(path = PathMapping.SAVE_LOCAL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<String> uploadSize(
			@RequestParam(value = PathMapping.File.FILE_PARAM_VAR, required = true) MultipartFile file,
			@RequestParam(value = PathMapping.File.DATA_PARAM_VAR, required = true) String data,
			@RequestParam(value = PathMapping.File.FILE_TYPE_PARAM_VAR, required = true) FileType fileType)
					throws Exception {
		String response = fileService.saveFile(file.getBytes(), data, FileType.IMAGE);
		if (response == null) {
			throw new MyException(ResponseCode.NO_URL_PRESENT);
		}
		return new BaseResponse<String>(false, response, ResponseCode.OK);
	}
}
