package com.emp.service.Impl;

import java.io.IOException;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.emp.constants.Params;
import com.emp.dao.IFileDao;
import com.emp.enums.FileType;
import com.emp.enums.ResponseCode;
import com.emp.exception.MyException;
import com.emp.mapper.FileMapper;
import com.emp.model.File;
import com.emp.response.dto.FileResponseDto;
import com.emp.service.IFileService;
import com.emp.utils.FileUtils;
import com.emp.utils.PropertiesUtil;

@Service
public class FileService implements IFileService {
	@Autowired
	private IFileDao fileDao;

	private Cloudinary cloudinaryClient;

	@PostConstruct
	private void init() throws IOException {
		@SuppressWarnings("rawtypes")
		Map params = PropertiesUtil.getPropertiesAsMap(Params.Cloudinary.CLOUDINARY_CLIENT_PROPS_FILE);
		if (params != null) {
			cloudinaryClient = new Cloudinary(params);
		}
	}

	@Override
	public String saveFile(byte[] file, String fileName, FileType fileType) throws Exception, MyException {
		return FileUtils.saveBytesAsFile(file, fileName, fileType);
	}

	@Override
	public FileResponseDto saveFileLocalDisk(MultipartFile file) throws Exception, MyException {
		String url = FileUtils.saveMultipartFile(file);
		if (url == null) {
			throw new MyException(ResponseCode.NO_FILE_SAVE);
		}
		File response = new File();
		response.setFilename(file.getOriginalFilename());
		response.setUrl(url);
		fileDao.save(response);
		return FileMapper.convertEntityToResponse(response);
	}

	@Override
	public String saveFileCloud(MultipartFile file, FileType fileType) throws Exception, MyException {
		String response = null;
		switch (fileType) {
		case IMAGE:
		case PDF:
			if (cloudinaryClient != null) {
				@SuppressWarnings("rawtypes")
				Map params = PropertiesUtil.getPropertiesAsMap(Params.Cloudinary.CLOUDINARY_CLIENT_PROPS_FILE);
				@SuppressWarnings("rawtypes")
				Map result = FileUtils.uploadToCloudinary(cloudinaryClient, file.getBytes(), params);
				if (result == null) {
					return null;
				}
				response = result.get(Params.Cloudinary.Result.RESULT_URL).toString();
			}
			break;
		default:
			throw new MyException(ResponseCode.FILE_TYPE_NOT_SUPPORTED);
		}
		return response;
	}
}
