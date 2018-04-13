package com.emp.constants;

public interface Params {

	public interface Cloudinary {
		public String CLOUDINARY_CLIENT_PROPS_FILE = "cloudinary.properties";
		public String CLOUDINARY_UPLOAD_PROPS_FILE = "cloudinaryUpload.properties";

		public interface Client {
			public String CLOUD_NAME = "cloud_name";
			public String API_KEY = "api_key";
			public String API_SECRET_KEY = "api_secret";
		}

		public interface Result {
			public String RESULT_URL = "url";
		}
	}

}
