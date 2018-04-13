package com.emp.enums;

public enum FileType {
	PDF(1), IMAGE(2);

	private int code;

	public int getCode() {
		return code;
	}

	private FileType(int code) {
		this.code = code;
	}

	public static FileType getFileType(int code) {
		for (FileType type : FileType.values()) {
			if (type.getCode() == code) {
				return type;
			}
		}
		return null;
	}
}
