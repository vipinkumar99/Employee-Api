package com.emp.enums;

public enum FileLocation {
	LOCAL(1), CLOUD(2);

	private int code;

	public int getCode() {
		return code;
	}

	private FileLocation(int code) {
		this.code = code;
	}

	public static FileLocation getFileLocation(int code) {
		for (FileLocation type : FileLocation.values()) {
			if (type.getCode() == code) {
				return type;
			}
		}
		return null;
	}
}
