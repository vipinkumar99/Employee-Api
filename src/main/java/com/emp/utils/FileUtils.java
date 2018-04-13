package com.emp.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.emp.enums.FileType;

public class FileUtils {

	private static String SAVE_FOLDER = "D:/EclipseIDE/Eclipseproject";
	private static String IMAGE_FOLDER = SAVE_FOLDER + "/Upload_Images/";

	static {
		File fileDir = new File(IMAGE_FOLDER);
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}
	}

	public static String saveMultipartFile(MultipartFile file) throws IOException {
		return saveBytesAsFile(file.getBytes(), file.getOriginalFilename());

	}

	public static String saveBytesAsFile(byte[] bytesToSave, String fileName) throws IOException {
		if (bytesToSave == null) {
			return null;
		}
		Path path = null;
		Date currentDate = new Date();
		String FILE_NAME = "upload_" + DateUtils.dateConversion(currentDate, DateUtils.FILE_DATE_FORMAT) + "_"
				+ fileName;

		path = Paths.get(IMAGE_FOLDER + FILE_NAME);
		Files.write(path, bytesToSave);
		return (path != null) ? path.toAbsolutePath().toString() : null;
	}

	public static String saveBytesAsFile(byte[] bytesToSave, String fileName, FileType fileType) throws IOException {
		if (bytesToSave == null || fileName == null) {
			return null;
		}
		Path path = null;
		switch (fileType) {
		case IMAGE:
			path = Paths.get(IMAGE_FOLDER + fileName);
			Files.write(path, bytesToSave);
		default:
			break;
		}
		return (path != null) ? path.toAbsolutePath().toString() : null;
	}

	@SuppressWarnings("rawtypes")
	public static Map uploadToCloudinary(Cloudinary client, Object filePath, Map uploadParams)
			throws IOException, RuntimeException {
		if (client == null || filePath == null) {
			return null;
		}
		if (uploadParams == null) {
			uploadParams = new HashMap();
		}
		Map uploadResult = client.uploader().upload(filePath, uploadParams);
		return uploadResult;
	}

}
