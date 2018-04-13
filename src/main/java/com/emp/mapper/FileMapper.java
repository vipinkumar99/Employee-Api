package com.emp.mapper;

import com.emp.model.File;
import com.emp.response.dto.FileResponseDto;
import com.emp.utils.DateUtils;

public class FileMapper {

	public static FileResponseDto convertEntityToResponse(File request) {
		if (request == null) {
			return null;
		}
		FileResponseDto response = new FileResponseDto();
		response.setId(request.getId());
		response.setName(request.getFilename());
		response.setUrl(request.getUrl());
		response.setCreated(DateUtils.dateConversion(request.getCreated(), DateUtils.FIRST_DATE_FORMAT));
		response.setUpdated(DateUtils.dateConversion(request.getUpdated(), DateUtils.FILE_DATE_FORMAT));
		return response;
	}

}
