package com.emp.service;

import org.springframework.web.multipart.MultipartFile;

import com.emp.enums.FileType;
import com.emp.exception.MyException;
import com.emp.response.dto.FileResponseDto;

public interface IFileService {
	public String saveFile(byte[] file, String fileName, FileType fileType) throws Exception, MyException;

	public FileResponseDto saveFileLocalDisk(MultipartFile file) throws Exception, MyException;

	public String saveFileCloud(MultipartFile file, FileType fileType) throws Exception, MyException;
}
