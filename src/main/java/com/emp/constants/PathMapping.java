package com.emp.constants;

public interface PathMapping {
	String BASE = "/";
	String All = "/all";
	String PAGINATION = "/pagination";
	String SAVE = "/save";
	String ID = "id";
	String ID_PARAM = "/{" + ID + "}";
	String NAME = "name";
	String NAME_PARAM = "/name/{" + NAME + "}";
	String UDATE = "/update";
	String CID = "id";
	String CATEGORY_ID = "/category/{" + CID + "}";
	String LOGIN = "/login";
	String PASSWORD = "/password";
	String PAGE_PARAM = "page";
	String PAGE_SIZE_PARAM = "size";
	String UPLOAD = "/upload";
	String SAVE_LOCAL = "/local";

	interface EmployeeMapping {
		String Base = "/employee";
	}

	interface CompanyMapping {
		String Base = "/company";
		String START = "start";
		String END = "end";
	}

	interface CategoryMapping {
		String Base = "/category";
	}

	interface ItemMapping {
		String Base = "/item";
	}

	interface RoleMapping {
		String Base = "/role";
	}

	interface AdminMapping {
		String Base = "/admin";
	}

	public interface File {
		public String BASE = "/file";
		public String FILE_PARAM_VAR = "file";
		public String DATA_PARAM_VAR = "data";
		public String FILE_TYPE_PARAM_VAR = "fileType";
	}

}
