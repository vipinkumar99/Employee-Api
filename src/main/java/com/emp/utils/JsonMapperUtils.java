package com.emp.utils;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class JsonMapperUtils {

	public static <T> String convertObjectToJson(T data) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T convertJsonToObject(String jsonData, Class<T> clazz) {
		T parsreData = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			parsreData = objectMapper.readValue(jsonData, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parsreData;
	}
	
	public static <T> List<T> convertToList(String jsonData, Class<T> clazz) {
		List <T> parsreData = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			parsreData = objectMapper.readValue(jsonData, new TypeReference<List<T>>() {
			} );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parsreData;
	}
	
}
