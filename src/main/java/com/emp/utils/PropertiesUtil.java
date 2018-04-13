package com.emp.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil {

	protected static Properties fetchProperties(String PropFileName) throws IOException {
		InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(PropFileName);
		if (inputStream == null) {
			return null;
		}
		Properties properties = new Properties();
		properties.load(inputStream);
		return properties;
	}

	public static Map<String, String> getPropertiesAsMap(String PropFileName) throws IOException {
		Properties properties = fetchProperties(PropFileName);
		if (properties == null) {
			return null;
		}
		Map<String, String> result = new HashMap<>();
		for (String key : properties.stringPropertyNames())
			result.put(key, properties.getProperty(key));
		return result;

	}
}
